FROM openjdk:17-jdk-alpine
WORKDIR /opt/app
RUN apk update && apk add --no-cache tzdata
ENV TZ=America/Sao_Paulo
COPY --from=docker.elastic.co/observability/apm-agent-java:1.50.0 /usr/agent/elastic-apm-agent.jar /elastic-apm-agent.jar
COPY ./target/investment-0.0.1.jar /opt/app/app.jar
ENTRYPOINT java -Xms256M -Xmx1024M -javaagent:/elastic-apm-agent.jar \
           -Delastic.apm.service_name=logstash-test-server \
           -Delastic.apm.server_url=http://172.18.10.29:8200 \
           -Delastic.apm.environment=logstash \
           -Delastic.apm.application_packages=go.def \
           -Djava.security.egd=file:/dev/./urandom \
           -jar /opt/app/app.jar
#CMD ["java", "-jar", "/opt/app/app.jar"]
