FROM openjdk:21
VOLUME /tmp
# ENV IMG_PATH=/IMG_PATH
EXPOSE 50001
# RUN mkdir -p /img 
COPY ./target/demo-rest-clientes-0.0.1-SNAPSHOT.jar demo-rest-clientes.jar
ENTRYPOINT ["java","-jar","/demo-rest-clientes.jar"]