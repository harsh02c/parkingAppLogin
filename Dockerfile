FROM openjdk:8
EXPOSE 8080
ADD target/parkingapplogin.jar parkingapplogin.jar
ENTRYPOINT ["java","-jar","parkingapplogin.jar"]