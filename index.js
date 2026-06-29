const functions = require("firebase-functions");
const admin = require("firebase-admin");
admin.initializeApp();

const db = admin.firestore();

// Provider order: Gemini -> Groq -> OpenRouter -> Together -> Cloudflare -> HF
const providers = [
  { id: "gemini", name: "Gemini", capable: ["text", "vision"] },
  { id: "groq", name: "Groq", capable: ["text"] },
  { id: "openrouter", name: "OpenRouter", capable: ["text"] },
  { id: "together", name: "Together AI", capable: ["text"] },
  { id: "cloudflare", name: "Cloudflare", capable: ["text"] },
  { id: "huggingface", name: "HuggingFace", capable: ["text"] }
];

exports.aiGateway = functions.https.onCall(async (data, context) => {
  // 1. Auth & App Check
  if (!context.auth) {
    throw new functions.https.HttpsError("unauthenticated", "User must be logged in.");
  }

  const { feature, input, sessionId, lang, modality = "text" } = data;
  const uid = context.auth.uid;

  // 2. Rate Limiting (Basic)
  const userRef = db.collection("_counters").document(`user_${uid}_ai`);
  // (In a real implementation, increment and check against quota)

  // 3. Prompt Assembly
  const promptTemplate = await db.collection("aiPromptTemplates")
    .where("feature", "==", feature)
    .where("language", "==", lang)
    .where("isActive", "==", true)
    .limit(1)
    .get();

  let systemPrompt = "You are Marobac AI, a helpful tutor for Moroccan students.";
  if (!promptTemplate.empty) {
    systemPrompt = promptTemplate.docs[0].data().systemPrompt;
  }

  // 4. Provider Routing & Failover
  let response = null;
  let error = null;

  for (const provider of providers) {
    // Check capability
    if (modality === "vision" && !provider.capable.includes("vision")) continue;

    try {
      console.log(`Trying provider: ${provider.id}`);
      response = await callProvider(provider.id, systemPrompt, input);
      if (response) break;
    } catch (e) {
      console.error(`Provider ${provider.id} failed: ${e.message}`);
      error = e;
      // Continue to next provider in failover chain
    }
  }

  if (!response) {
    throw new functions.https.HttpsError("unavailable", "All AI providers are currently unavailable. Please try again later.");
  }

  // 5. Persistence
  await db.collection("users").doc(uid).collection("aiSessions").doc(sessionId || "default").collection("messages").add({
    role: "assistant",
    content: response,
    createdAt: admin.firestore.FieldValue.serverTimestamp(),
    providerUsed: response.providerId
  });

  return { content: response };
});

async function callProvider(providerId, systemPrompt, input) {
  // Mocking the actual API calls to providers
  // In a real implementation, use fetch/axios with Secret Manager keys
  return `This is a response from ${providerId} for: ${input}`;
}
