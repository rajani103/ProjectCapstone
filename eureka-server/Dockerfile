FROM openjdk:11
WORKDIR usr/src
EXPOSE 8761
ADD ./target/eureka-server-0.0.1-SNAPSHOT.war /usr/src/eureka-server-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar", "eureka-server-0.0.1-SNAPSHOT.war"]
