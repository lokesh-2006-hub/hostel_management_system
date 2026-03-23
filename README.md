# Hostel Management System

## Description

The **Hostel Management System** is a comprehensive web application designed for college students to manage their hostel stays efficiently. It allows students to register, apply for hostel rooms, track room allocation status, and receive AI-powered recommendations for optimal room assignments or renewals.

## Features

- **Student Registration:** Secure registration process for new students.
- **Room Allocation:** Automatic and manual room allocation based on availability and preferences.
- **Complaint Management:** System for students to log and track their complaints.
- **Fee/Payment Tracking:** Real-time tracking of hostel fees and payments.
- **AI-Based Recommendation Logic:** Intelligent recommendations for room allocation or renewal.

## Tech Stack

- **Frontend:** React
- **Backend:** SpringBoot
- **Build Tool:** Gradle
- **Database:** MySQL

## Prerequisites

Before running the Hostel Management System, ensure you have the following installed on your machine:

1. **Java Development Kit (JDK):** Version 8 or higher.
2. **Node.js and npm:** Latest LTS version.
3. **MySQL Server:** Running instance with a database created for the application.

## Step-by-Step Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/hostel_management_system.git
   cd hostel_management_system
   ```

2. **Set Up Database:**
   
   - Ensure MySQL Server is running.
   - Create a new database for the application (e.g., `hostel_db`).

3. **Configure Application Properties:**

   - Copy `application.properties.example` in the backend to `application.properties`.
   - Update the database connection settings, such as URL, username, and password.

4. **Build Backend:**
   
   ```bash
   ./gradlew build
   ```

5. **Install Frontend Dependencies (if applicable):**

   ```bash
   cd frontend
   npm install
   ```

## How to Run Backend

1. Navigate to the backend directory:

   ```bash
   cd backend
   ```

2. Start the Spring Boot application:

   ```bash
   java -jar build/libs/HostelManagementSystemApplication.jar
   ```

   The backend server will start on `http://localhost:8080`.

## How to Run Frontend

1. Navigate to the frontend directory:

   ```bash
   cd frontend
   ```

2. Start the React development server:

   ```bash
   npm start
   ```

   The frontend application will be accessible at `http://localhost:3000`.

## API Endpoints Table

| Method | Endpoint                    | Description                                      |
|--------|-----------------------------|--------------------------------------------------|
| POST   | `/api/auth/login`           | Authenticate user                                |
| POST   | `/api/auth/register`        | Register new student                             |
| GET    | `/api/rooms`                | Get room inventory                               |
| POST   | `/api/room_allocation`      | Allocate room to a student                       |
| GET    | `/api/student/complaints`   | Get complaints for a student                     |
| POST   | `/api/student/complaints`  | Create a new complaint                           |
| GET    | `/api/payments`             | Track payments                                   |
| POST   | `/api/payments`            | Make payment                                     |

## Folder Structure

```
hostel_management_system/
├── backend/
│   ├── src/
│   └── build.gradle
├── frontend/
│   ├── public/
│   ├── src/
│   └── package.json
├── README.md
└── gradlew
```

- **backend/**: Contains the SpringBoot application code.
- **frontend/**: Contains the React application code.
- **README.md**: This file.
- **gradlew**: Gradle wrapper script for building the backend.

## Troubleshooting

1. **Backend Not Starting:**
   - Ensure MySQL is running and database connection details are correct.
   - Check logs in `backend/build/libs/` for any error messages.

2. **Frontend Connection Issues:**
   - Verify that the backend server is running on `http://localhost:8080`.
   - Check console logs in the browser for any network errors.

## Security Notes

- The application has been tested for common security vulnerabilities.
- Ensure that all sensitive data, such as database credentials, are stored securely and not hard-coded in the repository.
- Regularly update dependencies to patch known vulnerabilities.

For further assistance or inquiries, please contact the development team at [email@example.com](mailto:email@example.com).