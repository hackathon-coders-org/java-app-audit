FROM eclipse-temurin:17-jre
COPY target/audit-1.0.0.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
