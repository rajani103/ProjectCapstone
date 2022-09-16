FROM openjdk:11
ADD ./target/tag-team-service-0.0.1-SNAPSHOT.war /usr/src/tag-team-service-0.0.1-SNAPSHOT.war
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "tag-team-service-0.0.1-SNAPSHOT.war"]
