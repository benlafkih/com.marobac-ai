import os
from pypdf import PdfReader

def extract_text_from_pdf(pdf_path):
    try:
        reader = PdfReader(pdf_path)
        text = ""
        for page in reader.pages:
            text += page.extract_text() + "\n"
        return text
    except Exception as e:
        return f"Error reading {pdf_path}: {e}"

uploads_dir = "uploads"
output_dir = "extracted_docs"
os.makedirs(output_dir, exist_ok=True)

for filename in os.listdir(uploads_dir):
    if filename.endswith(".pdf"):
        pdf_path = os.path.join(uploads_dir, filename)
        text_content = extract_text_from_pdf(pdf_path)
        output_filename = filename.replace(".pdf", ".txt")
        with open(os.path.join(output_dir, output_filename), "w") as f:
            f.write(text_content)
        print(f"Extracted: {filename}")
