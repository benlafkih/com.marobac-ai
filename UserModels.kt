package com.marobac.ai.domain.model

import java.util.Date

data class User(
    val uid: String,
    val role: String, // "student", "teacher", "parent", "admin"
    val displayName: String,
    val email: String?,
    val photoUrl: String?,
    val language: String,
    val level: String?,
    val stream: String?,
    val targetGoal: String?,
    val xp: Int = 0,
    val userLevel: Int = 1,
    val coins: Int = 0,
    val streakCount: Int = 0,
    val lastActiveDate: Date? = null,
    val onboardingDone: Boolean = false
)

data class Progress(
    val conceptId: String,
    val subjectId: String,
    val masteryScore: Float, // 0.0 - 1.0
    val attempts: Int,
    val status: String // "weak", "improving", "mastered"
)

data class StudyTask(
    val id: String,
    val date: Date,
    val taskType: String, // "lesson", "exercise", "exam"
    val refId: String,
    val status: String // "pending", "done", "skipped"
)
