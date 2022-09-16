FROM openjdk:11
ADD ./target/api-gateway-0.0.1-SNAPSHOT.war /usr/src/api-gateway-0.0.1-SNAPSHOT.war
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "api-gateway-0.0.1-SNAPSHOT.war"]
