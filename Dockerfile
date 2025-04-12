FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy Gradle wrapper and project files first to leverage caching
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Grant execution permission to Gradle wrapper
RUN chmod +x gradlew

# Use cache mount for Gradle dependencies
RUN --mount=type=cache,target=/root/.gradle ./gradlew dependencies

# Copy the source code
COPY src src

# Build the project (skip tests)
RUN --mount=type=cache,target=/root/.gradle ./gradlew build -x test

# Copy the built WAR file
COPY build/libs/worklog-service-0.0.1-SNAPSHOT.war app.war

EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.war"]
