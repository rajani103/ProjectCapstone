FROM openjdk:11
ADD ./target/interviewer-service-0.0.1-SNAPSHOT.war /usr/src/interviewer-service-0.0.1-SNAPSHOT.war
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "interviewer-service-0.0.1-SNAPSHOT.war"]
