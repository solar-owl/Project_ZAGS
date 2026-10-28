FROM maven:3.9-eclipse-temurin-17
LABEL authors="anastasiakarina"

WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src

ENV SELENOID_URL=http://selenoid:4444/wd/hub

ENTRYPOINT ["sh", "-c", "mkdir -p /app/target && find /app/target -mindepth 1 -delete && mvn -B test -Dselenoid.url=${SELENOID_URL} \"$@\"", "--"]