FROM amazoncorretto:20-alpine-jdk
MAINTAINER RamonCruz
COPY target/back-0.0.1-SNAPSHOT.jar app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8181
