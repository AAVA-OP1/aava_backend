
# RENDER
# FROM maven:3.8.6-eclipse-temurin-17-focal AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# # Package stage
# FROM eclipse-temurin:17-jre-focal
# COPY --from=build /home/app/target/kyselyprojekti-0.0.1-SNAPSHOT.jar /usr/local/lib/pkg.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/usr/local/lib/pkg.jar"]


# RAHTI
FROM eclipse-temurin:17-jdk-focal as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests 
RUN find ./target -type f -name '*.jar' -exec cp {} /opt/app/app.jar \; -quit

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder /opt/app/*.jar /opt/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar" ]