# Task Management Application

This is a task management application built according to Agile user stories (TA-01 - TA-04). The frontend was pre-built, and **the entire backend architecture and RESTful APIs were developed by me.**

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot, Spring Data JPA, Maven
* **Database:** PostgreSQL (Development), H2 Database (Isolated Testing)
* **Infrastructure:** Docker, Docker Compose

## 🚀 Features (User Stories)
* **TA-01 (Create a Task):** Add new tasks with title, description, due date, and priority level.
* **TA-02 (Update a Task):** Edit existing task details and status.
* **TA-03 (Delete a Task):** Permanently remove tasks from the system.
* **TA-04 (Complete a Task):** Toggle task states between `Open` and `Complete`.

## 🏁 How to Run

1. **Start the Database and Frontend:**
```bash
   docker-compose up -d
```
The UI will be accessible at http://localhost:3000.

2. **Run the Backend Application via your IDE or use the terminal:**
```bash
   ./mvnw spring-boot:run
```
The backend will run on port 8080.
