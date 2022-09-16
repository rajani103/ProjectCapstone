FROM openjdk:11
WORKDIR usr/src
ADD ./target/user-service-0.0.1-SNAPSHOT.war /usr/src/user-service-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar", "user-service-0.0.1-SNAPSHOT.war"]
