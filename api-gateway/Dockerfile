FROM openjdk:21
VOLUME /tmp
# ENV IMG_PATH=/IMG_PATH
EXPOSE 50003
# RUN mkdir -p /img 
COPY ./target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java","-jar","/api-gateway.jar"]