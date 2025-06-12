FROM openjdk:21
VOLUME /tmp
# ENV IMG_PATH=/IMG_PATH
EXPOSE 8099
# RUN mkdir -p /img 
COPY ./target/discover-0.0.1-SNAPSHOT.jar discover.jar
ENTRYPOINT ["java","-jar","/discover.jar"]