FROM openjdk:11
WORKDIR usr/src
EXPOSE 8761
ADD ./target/product-webapp-0.0.1-SNAPSHOT.jar /usr/src/product-webapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "product-webapp-0.0.1-SNAPSHOT.jar"]