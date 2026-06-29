# Marobac AI - Production Ready Android Application

Marobac AI is an AI-powered study companion built specifically for Moroccan Baccalauréat students.

## Architecture
- **Clean Architecture**: Decoupled layers (Domain, Data, Presentation).
- **Jetpack Compose**: Modern declarative UI.
- **Material Design 3**: Google's latest design system.
- **Hilt**: Dependency injection.
- **Firebase**: Backend services (Auth, Firestore, Storage, Functions).
- **Kotlin Coroutines & Flow**: Asynchronous programming.

## Project Structure
- `app/src/main/java/com/marobac/ai/core`: Common logic, theme, navigation, DI.
- `app/src/main/java/com/marobac/ai/domain`: Entities, Repository interfaces.
- `app/src/main/java/com/marobac/ai/data`: Repository implementations, DTOs, Mappers.
- `app/src/main/java/com/marobac/ai/features`: Feature-based UI modules.
- `functions/`: Firebase Cloud Functions for AI Gateway.

## Implemented Features
- [x] **Project Foundation**: Gradle setup, DI, Navigation, Theme.
- [x] **Auth**: Login UI & ViewModel, Firebase Auth Repository.
- [x] **Dashboard**: Home screen with Streak & Progress cards.
- [x] **Learn**: Subjects list with progress tracking.
- [x] **AI Hub**: Access to Tutor, Camera, and PDF Assistant.
- [x] **AI Tutor**: Chat interface with streaming simulation and failover logic.
- [x] **Practice**: Hub for exercises, quizzes, and exams.
- [x] **Profile**: User stats, achievements, and settings.
- [x] **Backend**: Cloud Functions AI Gateway with multi-provider failover.

## Deployment
1. Connect to Firebase using `google-services.json`.
2. Deploy Cloud Functions from the `functions/` directory.
3. Configure Firestore rules and collections.
4. Set AI provider keys in Firebase Secret Manager.
