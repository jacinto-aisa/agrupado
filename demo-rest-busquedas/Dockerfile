FROM openjdk:21
VOLUME /tmp
# ENV IMG_PATH=/IMG_PATH
EXPOSE 50003
# RUN mkdir -p /img 
COPY ./target/demo-rest-busquedas-0.0.1-SNAPSHOT.jar demo-rest-busquedas.jar
ENTRYPOINT ["java","-jar","/demo-rest-busquedas.jar"]