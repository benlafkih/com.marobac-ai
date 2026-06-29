package com.marobac.ai.domain.repository

import com.marobac.ai.domain.model.*
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun getCurrentUser(): Flow<User?>
    suspend fun signInWithEmail(email: String, pass: String): Result<Unit>
    suspend fun signUpWithEmail(email: String, pass: String): Result<Unit>
    suspend fun signOut()
}

interface UserRepository {
    fun getUserProfile(uid: String): Flow<User?>
    suspend fun updateUserProfile(user: User): Result<Unit>
}

interface ContentRepository {
    fun getSubjects(level: String, stream: String): Flow<List<Subject>>
    fun getLessons(subjectId: String): Flow<List<Lesson>>
    fun getLessonDetail(lessonId: String): Flow<Lesson?>
    fun getConcepts(lessonId: String): Flow<List<Concept>>
}

interface AiRepository {
    suspend fun askTutor(question: String, sessionId: String?, context: Map<String, Any>?): Result<String>
    suspend fun solveImage(imageUri: String): Result<String>
    suspend fun summarizePdf(pdfUri: String): Result<String>
}

interface ProgressRepository {
    fun getUserProgress(uid: String): Flow<List<Progress>>
    fun getStudyPlan(uid: String): Flow<List<StudyTask>>
}
