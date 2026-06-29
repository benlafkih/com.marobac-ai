package com.marobac.ai.domain.model

data class Subject(
    val id: String,
    val name: LocalizedString,
    val level: String, // "1bac", "2bac"
    val stream: String, // "sm", "sp", "svt"
    val icon: String,
    val order: Int,
    val description: LocalizedString,
    val lessonCount: Int
)

data class LocalizedString(
    val ar: String,
    val fr: String,
    val darija: String? = null
) {
    fun get(locale: String): String {
        return when (locale) {
            "ar" -> ar
            "fr" -> fr
            "darija" -> darija ?: ar
            else -> fr
        }
    }
}

data class Lesson(
    val id: String,
    val subjectId: String,
    val title: LocalizedString,
    val order: Int,
    val contentBlocks: List<ContentBlock>,
    val conceptIds: List<String>,
    val language: String,
    val isDownloadable: Boolean
)

data class ContentBlock(
    val type: String, // "text", "formula", "image", "video"
    val data: Map<String, Any>
)

data class Concept(
    val id: String,
    val lessonId: String,
    val subjectId: String,
    val name: LocalizedString,
    val prerequisites: List<String>,
    val difficulty: Int
)

data class Exercise(
    val id: String,
    val subjectId: String,
    val conceptIds: List<String>,
    val type: String, // "mcq", "open", "numeric", "proof"
    val difficulty: Int,
    val statement: LocalizedString,
    val choices: List<Choice>? = null,
    val solutionSteps: List<String>? = null
)

data class Choice(
    val id: String,
    val text: String
)
