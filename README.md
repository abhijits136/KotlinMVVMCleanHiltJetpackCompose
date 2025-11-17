# Kotlin MVVM Clean Architecture with Hilt and Jetpack Compose

This project serves as a comprehensive and production-ready template for a modern Android application. It demonstrates best practices by integrating MVVM, Clean Architecture, Hilt for dependency injection, and Jetpack Compose for the UI layer.

## Core Architecture

The application follows a strict Clean Architecture, separating the codebase into three distinct layers:

- **Domain Layer**: The core of the application. It contains the business logic (Use Cases) and the repository interfaces. This layer is pure Kotlin and has no knowledge of the Android framework or the data layer's implementation details.
- **Data Layer**: Responsible for providing data to the domain layer. It contains repository implementations, data mappers, and data sources (e.g., for network access and local database persistence with Room). It maps raw data models to clean domain models.
- **Presentation Layer**: The UI layer of the application. It uses Jetpack Compose for declarative UI, and MVVM (Model-View-ViewModel) to manage UI state and handle user interactions.

## Features

This template showcases a wide range of modern Android development features:

- **UI**: Built entirely with Jetpack Compose using Material 3 components.
- **Theming**: Full support for both Light and Dark themes, with a centralized design token system.
- **State Management**: Robust UI state management using a single `UiState` data class per screen, managed by the ViewModel with `StateFlow`.
- **Dependency Injection**: Project-wide dependency injection using Hilt. We even demonstrate build-variant-specific injection with the `AnalyticsService`.
- **Navigation**: A complete, plug-and-play navigation architecture using Jetpack Navigation Component, a `Scaffold`, a reusable `CommonAppBar`, and a `BottomNavBar`.
- **Networking**: A production-ready networking layer built with **Retrofit** and **OkHttp**. It includes a logging interceptor to show network traffic in Logcat for debug builds.
- **Graceful Error Handling**: Network responses are wrapped in a `NetworkResult` sealed class. This prevents crashes from network errors (e.g., no internet) and allows the UI to display a user-friendly error message.
- **Global Crash Handling**: A global `UncaughtExceptionHandler` is set up to catch any unexpected crashes. Instead of the app abruptly closing, the user is shown a friendly `CrashActivity` with an option to restart the app.
- **Reusable Components**:
  - A powerful, fully customizable `CustomDialog` system managed by a central `DialogManager`.
  - A modal `ErrorDialog` for a professional user experience.
  - A flexible `SplashScreen`.
- **Clean Architecture Principles**:
  - **Repository Pattern**: Abstracting data sources from the domain layer.
  - **Mappers**: Isolating data-layer models (Entities/DTOs) from domain-layer models.
  - **Use Cases**: Encapsulating specific pieces of business logic.
- **Testing**: Unit tests for ViewModels and Use Cases using Mockito and Truth.

## Project Structure

```
app/src/main/java/com/example/kotlinmvvmcleanhiltjetpackcompose
├── data                # Data Layer
│   ├── config
│   ├── logging
│   ├── mapper          # Mappers from data models to domain models
│   ├── model           # Raw data models (Entities/DTOs)
│   ├── remote          # Network API definitions and DTOs
│   └── repository      # Repository implementations
├── di                  # Hilt Dependency Injection Modules
├── domain              # Domain Layer
│   ├── model           # Core domain models
│   ├── repository      # Repository interfaces (the contract)
│   └── use_case        # Business logic
└── presentation        # Presentation (UI) Layer
    ├── common          # Common UI-related classes (e.g., ErrorHandler)
    ├── navigation      # Navigation components (Screen, BottomNavBar)
    └── ui
        ├── components  # Reusable UI components (AppBar, Dialogs)
        ├── favorites   # Favorites feature screen
        ├── showcase    # Example feature screen
        └── theme       # Theming and Design Tokens
```

## Build Flavors

This project uses build flavors to manage different environments. The following flavors are configured:

-   **`dev`**: For the development environment. It has an `applicationIdSuffix` of `.dev` so it can be installed alongside the production version.
-   **`prod`**: For the production environment, intended for release builds.

Each flavor has its own source sets (`src/dev/` and `src/prod/`), allowing for different configurations, resources, and even code. A key example of this is the `AnalyticsModule`, which uses Hilt to provide a `CustomAnalyticsService` in `dev` builds (which logs to Logcat) and a `FirebaseAnalyticsService` in `prod` builds. This powerful pattern allows you to easily swap out implementations for different environments.

You can switch between build variants (e.g., `devDebug`, `prodRelease`) using the **Build Variants** panel in Android Studio.

## Code Shrinking and Obfuscation

This project is configured to use [R8](https://developer.android.com/studio/build/shrink-code) (with ProGuard rules) to shrink and obfuscate the code for release builds. This helps to reduce the app's size and protect the source code from reverse engineering.

-   **Enabled in:** `release` build type (`isMinifyEnabled = true`).
-   **Configuration File:** Custom rules are located in `app/proguard-rules.pro`.

When adding new dependencies or classes that rely on reflection (e.g., for serialization), please remember to add the necessary `-keep` rules to this file to prevent them from being removed or obfuscated.

## How to Use

1.  Clone the repository.
2.  Open the project in the latest version of Android Studio.
3.  Let Gradle sync the dependencies.
4.  Build and run the application on an emulator or a physical device.
