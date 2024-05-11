# Stage 1: Build the application
FROM gradle:jdk17-jammy AS builder

# Set working directory
WORKDIR /app

# Copy Gradle files for dependency resolution
COPY build.gradle .
COPY settings.gradle .
#COPY gradle.properties .

# Copy the entire project
COPY . .

# Build the application
RUN gradle clean build --no-daemon

# Stage 2: Run the application
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage to the runtime stage
COPY --from=builder /app/search-app/build/libs/search-app.jar search-app.jar
#COPY --from=builder . .
# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "search-app.jar"]
