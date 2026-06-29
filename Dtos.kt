package com.marobac.ai.data.remote.dto

import com.google.firebase.Timestamp
import com.marobac.ai.domain.model.*

data class UserDto(
    val uid: String = "",
    val role: String = "student",
    val displayName: String = "",
    val email: String? = null,
    val photoUrl: String? = null,
    val language: String = "fr",
    val level: String? = null,
    val stream: String? = null,
    val targetGoal: String? = null,
    val xp: Int = 0,
    val userLevel: Int = 1,
    val coins: Int = 0,
    val streakCount: Int = 0,
    val lastActiveDate: Timestamp? = null,
    val onboardingDone: Boolean = false
)

data class SubjectDto(
    val id: String = "",
    val name: Map<String, String> = emptyMap(),
    val level: String = "",
    val stream: String = "",
    val icon: String = "",
    val order: Int = 0,
    val description: Map<String, String> = emptyMap(),
    val lessonCount: Int = 0
)

data class LessonDto(
    val id: String = "",
    val subjectId: String = "",
    val title: Map<String, String> = emptyMap(),
    val order: Int = 0,
    val contentBlocks: List<Map<String, Any>> = emptyList(),
    val conceptIds: List<String> = emptyList(),
    val language: String = "fr",
    val isDownloadable: Boolean = false
)

data class ConceptDto(
    val id: String = "",
    val lessonId: String = "",
    val subjectId: String = "",
    val name: Map<String, String> = emptyMap(),
    val prerequisites: List<String> = emptyList(),
    val difficulty: Int = 1
)
