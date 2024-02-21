FROM openjdk:17-jdk
LABEL maintainer="pavani sunguluru <pavani.sunguluru1@gmail.com>"
COPY target/servicediscovery-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8000
RUN echo "STARTING THE ADMIN SERVICE"
ENTRYPOINT ["java","-jar","servicediscovery-0.0.1-SNAPSHOT.jar"]

