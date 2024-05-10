# Use official OpenJDK 17 image as base
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/your-application.jar /app/your-application.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "your-application.jar"]
