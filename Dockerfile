# STEP 1: The "Build" Environment
# This downloads Maven and JDK to compile your Struts code
FROM maven:3.8-openjdk-11 AS builder
WORKDIR /app

# Copy only the pom.xml first to cache dependencies (faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy your source code and build the .war file
COPY src ./src
RUN mvn clean package -DskipTests

# STEP 2: The "Run" Environment
# This is the actual lightweight image that gets pushed to your repo
FROM tomcat:9-jdk11-slim
WORKDIR /usr/local/tomcat/webapps/
# Remove default apps (cleaner attack surface)
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy the .war from the 'builder' stage to Tomcat
# We rename it to ROOT.war so it loads at the base URL (http://localhost:8080/)
COPY --from=builder /app/target/*.war ./ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
