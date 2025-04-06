# Java Quiz System

A Java application for MCQ-based quizzes with role-based login.

## Features

- **Admin Login**
  - Add multiple MCQ questions to `quiz.json`
  - Add as many as needed until pressing `q` to quit

- **Student Login**
  - Take a 10-question quiz from the quiz bank
  - Get scored and receive feedback based on performance

## Files

- `users.json` — Stores user credentials (admin and students)
- `quiz.json` — Stores quiz questions and correct answers

## How to Run

1. Clone this repository
2. Open in any Java IDE (Java 17+ required)
3. Run the `Main` class from `org.example` package
4. Login using:
   - Admin: `admin` / `1234`
   - Student: `salman` / `1234`
