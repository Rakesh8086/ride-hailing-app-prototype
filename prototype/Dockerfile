# Use a lightweight base image with Java installed
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to download dependencies
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application using Maven
RUN mvn clean package -DskipTests

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "target/prototype-0.0.1-SNAPSHOT.jar"]