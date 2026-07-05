# Base Image
FROM eclipse-temurin:21-jre

# Working directory inside the container
WORKDIR /app

# Copy the JAR into the image
COPY target/restaurantlisting-0.0.1-SNAPSHOT.jar app.jar

# Spring Boot application port
EXPOSE 9081

# Command to start the application
ENTRYPOINT ["java", "-jar", "app.jar"]