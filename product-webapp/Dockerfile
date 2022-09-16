FROM openjdk:11
WORKDIR usr/src
EXPOSE 8761
ADD ./target/product-webapp-0.0.1-SNAPSHOT.war /usr/src/product-webapp-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar", "product-webapp-0.0.1-SNAPSHOT.war"]
