# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/MongoDbOAuth-0.0.1-SNAPSHOT.jar /app/MongoDbOAuth-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

ENV DB_HOST=test
ENV DB_PORT=5432
ENV DB_NAME=nomad
ENV DB_USERNAME=ttttt
ENV DB_PASSWORD=team27
ENV TABLE_NAME=film

# Run the application using spring profiles and setting the environment variables
CMD ["java", "-jar", "-Dspring.profiles.active=dev", "MongoDbOAuth-0.0.1-SNAPSHOT.jar"]