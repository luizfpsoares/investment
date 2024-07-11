FROM openjdk:17-jdk-alpine
WORKDIR /opt/app
RUN apk update && apk add --no-cache tzdata
ENV TZ=America/Sao_Paulo
COPY ./target/investment-0.0.1.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]