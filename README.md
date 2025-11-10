# Kotlin MVVM Clean Architecture with Hilt and Jetpack Compose

This project serves as a comprehensive and production-ready template for a modern Android application. It demonstrates best practices by integrating MVVM, Clean Architecture, Hilt for dependency injection, and Jetpack Compose for the UI layer.

## Core Architecture

The application follows a strict Clean Architecture, separating the codebase into three distinct layers:

- **Domain Layer**: The core of the application. It contains the business logic (Use Cases) and the repository interfaces. This layer is pure Kotlin and has no knowledge of the Android framework or the data layer's implementation details.
- **Data Layer**: Responsible for providing data to the domain layer. It contains repository implementations, data mappers, and data sources (e.g., Retrofit for network, Room for database). It maps raw data models (Entities/DTOs) to clean domain models.
- **Presentation Layer**: The UI layer of the application. It uses Jetpack Compose for declarative UI, and MVVM (Model-View-ViewModel) to manage UI state and handle user interactions.

## Features

This template showcases a wide range of modern Android development features:

- **UI**: Built entirely with Jetpack Compose using Material 3 components.
- **Theming**: Full support for both Light and Dark themes, with a centralized design token system.
- **State Management**: Robust UI state management using a single `UiState` data class per screen, managed by the ViewModel with `StateFlow`.
- **Dependency Injection**: Project-wide dependency injection using Hilt.
- **Navigation**: A complete, plug-and-play navigation architecture using Jetpack Navigation Component, a `Scaffold`, a reusable `CommonAppBar`, and a `BottomNavBar`.
- **Reusable Components**:
  - A powerful, fully customizable `CustomDialog` system managed by a central `DialogManager`.
  - A modal `ErrorDialog` for a professional user experience.
  - A flexible `SplashScreen`.
- **Clean Architecture Principles**:
  - **Repository Pattern**: Abstracting data sources from the domain layer.
  - **Mappers**: Isolating data-layer models (Entities) from domain-layer models.
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
        ├── showcase    # Example feature screen
        └── theme       # Theming and Design Tokens
```

## How to Use

1.  Clone the repository.
2.  Open the project in the latest version of Android Studio.
3.  Let Gradle sync the dependencies.
4.  Build and run the application on an emulator or a physical device.
