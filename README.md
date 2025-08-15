# BookCatcher

BookCatcher is an Android application that allows users to track their book reading progress. It's a simple and intuitive app designed to help you stay motivated and keep a record of your reading journey.

![image](https://github.com/annevermor/BookCatcher/assets/104998735/1f3b75ad-b3ef-4201-9809-1f8a43d0eabe)

## Features

*   **Add and Manage Books:** Easily add new books to your reading list and manage their status (e.g., currently reading, finished).
*   **Track Reading Progress:** Record the number of pages you've read and see your progress over time.
*   **Visualize Your Reading:** View your reading statistics with insightful charts.
*   **Offline Support:** All your data is stored locally on your device, so you can use the app without an internet connection.

## Technologies Used

This project is built with a modern Android technology stack:

*   **Kotlin:** The programming language used for the entire project.
*   **Jetpack Compose:** For building the user interface.
*   **Room:** For local data storage (SQLite).
*   **ViewModel:** To manage UI-related data and handle user interactions.
*   **Navigation Compose:** For navigating between screens.
*   **YCharts:** To create beautiful and interactive charts.
*   **MVVM Architecture:** The app follows the Model-View-ViewModel architectural pattern.

## Project Structure

The project is organized into the following main packages:

*   `data`: Contains the Room database, DAO, data models, and repository for data handling.
*   `navigation`: Manages the navigation flow of the app.
*   `ui`: Includes all the Jetpack Compose screens and themes.
*   `viewModel`: Holds the ViewModels responsible for the app's business logic.

## How to Build

To build and run this project, you will need:

1.  Android Studio
2.  An Android device or emulator

Simply clone the repository and open it in Android Studio. The project should build and run without any additional configuration.

```bash
git clone https://github.com/annevermor/BookCatcher.git
```
