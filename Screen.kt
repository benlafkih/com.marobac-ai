package com.marobac.ai.core.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Onboarding : Screen("onboarding")
    object Dashboard : Screen("dashboard")
    object Learn : Screen("learn")
    object AiHub : Screen("ai_hub")
    object Practice : Screen("practice")
    object Profile : Screen("profile")
    
    // Detail screens
    object LessonDetail : Screen("lesson_detail/{lessonId}") {
        fun createRoute(lessonId: String) = "lesson_detail/$lessonId"
    }
}
