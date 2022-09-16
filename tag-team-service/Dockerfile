FROM openjdk:11
ADD ./target/tag-team-service-0.0.1-SNAPSHOT.jar /usr/src/tag-team-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "tag-team-service-0.0.1-SNAPSHOT.jar"]