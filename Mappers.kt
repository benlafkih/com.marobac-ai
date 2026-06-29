package com.marobac.ai.data.mapper

import com.marobac.ai.data.remote.dto.*
import com.marobac.ai.domain.model.*

fun UserDto.toUser(): User = User(
    uid = uid,
    role = role,
    displayName = displayName,
    email = email,
    photoUrl = photoUrl,
    language = language,
    level = level,
    stream = stream,
    targetGoal = targetGoal,
    xp = xp,
    userLevel = userLevel,
    coins = coins,
    streakCount = streakCount,
    lastActiveDate = lastActiveDate?.toDate(),
    onboardingDone = onboardingDone
)

fun SubjectDto.toSubject(): Subject = Subject(
    id = id,
    name = LocalizedString(ar = name["ar"] ?: "", fr = name["fr"] ?: "", darija = name["darija"]),
    level = level,
    stream = stream,
    icon = icon,
    order = order,
    description = LocalizedString(ar = description["ar"] ?: "", fr = description["fr"] ?: "", darija = description["darija"]),
    lessonCount = lessonCount
)

fun LessonDto.toLesson(): Lesson = Lesson(
    id = id,
    subjectId = subjectId,
    title = LocalizedString(ar = title["ar"] ?: "", fr = title["fr"] ?: "", darija = title["darija"]),
    order = order,
    contentBlocks = contentBlocks.map { ContentBlock(it["type"] as String, it["data"] as Map<String, Any>) },
    conceptIds = conceptIds,
    language = language,
    isDownloadable = isDownloadable
)

fun ConceptDto.toConcept(): Concept = Concept(
    id = id,
    lessonId = lessonId,
    subjectId = subjectId,
    name = LocalizedString(ar = name["ar"] ?: "", fr = name["fr"] ?: "", darija = name["darija"]),
    prerequisites = prerequisites,
    difficulty = difficulty
)
