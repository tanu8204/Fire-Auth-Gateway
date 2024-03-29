
# Use JDK 17 slim image for the build stage
FROM openjdk:17-jdk-slim AS build

# Copy the Gradle wrapper files to the container
COPY gradlew /app/
COPY gradle /app/gradle

# Copy the build configuration files
COPY build.gradle /app/
COPY settings.gradle /app/
COPY gradlew.bat /app/

# Set the working directory
WORKDIR /app

# Download dependencies and cache them to improve build speed
RUN ./gradlew build --no-daemon --stacktrace

# Copy the application source code
COPY . /app

chmod +x gradlew

# Build the JAR file
RUN ./gradlew bootJar

# Use JDK 17 slim image for the runtime environment
FROM openjdk:17.0.1-jdk-slim

# Expose port 8080
EXPOSE 8086

# Create a directory for the application
RUN mkdir /app

# Copy the built JAR from the build stage to the runtime stage
COPY --from=build /app/build/libs/*.jar /app/spring-boot-application.jar

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
