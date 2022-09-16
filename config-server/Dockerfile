FROM openjdk:11
ADD ./target/config-server-0.0.1-SNAPSHOT.war /usr/src/config-server-0.0.1-SNAPSHOT.war
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "config-server-0.0.1-SNAPSHOT.war"]
