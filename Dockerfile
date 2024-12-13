# Use a specific version of OpenJDK for consistency
FROM openjdk:17-jdk-slim

# Set a working directory (good practice)
WORKDIR /user/app

# Copy the application JAR file
COPY target/online-ticket-booking.jar /user/app/online-ticket-booking.jar

# Expose the application port (if your app runs on a specific port, e.g., 8080)
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "online-ticket-booking.jar"]