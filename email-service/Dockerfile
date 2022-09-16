FROM openjdk:11
ADD ./target/email-service-0.0.1-SNAPSHOT.war /usr/src/email-service-0.0.1-SNAPSHOT.war
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "email-service-0.0.1-SNAPSHOT.war"]
