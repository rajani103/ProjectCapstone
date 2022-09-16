FROM openjdk:11
ADD ./target/interviewer-service-0.0.1-SNAPSHOT.jar /usr/src/interviewer-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "interviewer-service-0.0.1-SNAPSHOT.jar"]