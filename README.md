# Fire-Auth-Gateway

Cloud Firebase db:
https://console.firebase.google.com/u/0/project/fir-db-5c67e/firestore/data/~2Fcrud_user

## FireAuthGateway

This is a Spring Boot application that provides RESTful API endpoints for user authentication using Firebase Authentication and Firestore as the backend database.

### Features
- User Registration: Allows users to register by providing a username and password.
- User Authentication: Provides endpoints for user authentication using Firebase Authentication.
- User Retrieval: Retrieves user details from the Firestore database.

### Technologies Used
- Java
- Spring Boot
- Firebase Authentication
- Firestore
- Lombok

### Setup Instructions
1. Clone the repository to your local machine.
2. Ensure you have Java Development Kit (JDK) installed.
3. Create a Firebase project and download the service account key file (`serviceAccountKey.json`).
4. Place the `serviceAccountKey.json` file in the root directory of the project.
5. Configure Firebase Authentication and Firestore in your Firebase project.
6. Update the `application.properties` file with your Firebase project configuration.
7. Build and run the application using Gradle.

### Endpoints

#### User Registration
- **URL:** `/api/users`
- **Method:** `POST`
- **Request Body:** JSON object containing `username` and `password` fields.
- **Response:** Returns a success message upon successful user registration.

#### User Authentication
- **URL:** `/api/users/{username}`
- **Method:** `GET`
- **Request Parameters:** Username
- **Response:** Retrieves user details from the Firestore database.

### Testing with Postman
You can test the API endpoints using [Postman](https://www.postman.com/):

1. **User Registration:**
   - Open Postman and create a new request with the URL `http://localhost:8085/api/users`.
   - Set the request method to `POST`.
   - In the request body, provide a JSON object with the `username` and `password` fields.
   - Send the request to register a new user.

2. **User Authentication:**
   - Create another request with the URL `http://localhost:8085/api/users/{username}`, replacing `{username}` with the username of the user you want to retrieve.
   - Set the request method to `GET`.
   - Send the request to retrieve user details from the Firestore database.

### Additional Notes
- This project demonstrates the integration of Spring Boot with Firebase Authentication and Firestore.
- The `FireBaseInitialization` class initializes the Firebase App with the service account key.
- Security is configured using Spring Security in the `SecurityConfig` class.
- Lombok is used to reduce boilerplate code in entity classes.

### Firebase Integration
- Firebase Authentication is used for user authentication, providing secure sign-in methods.
- Firestore is utilized as the NoSQL database for storing user data securely in the cloud.

### Author
This project is authored by TANU KUMARI. 
