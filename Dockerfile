FROM openjdk:8-jdk-alpine
MAINTAINER Kishinka Roman
VOLUME [ "/tmp" ]
COPY  target/SoapShop.jar app.jar
EXPOSE 9977
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
