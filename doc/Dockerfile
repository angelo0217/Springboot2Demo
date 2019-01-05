FROM java:8u111-jre-alpine

MAINTAINER Dean dean@gmail.com

ENV SERVER_IP=192.168.0.107

RUN mkdir /workspace \
    && mkdir /workspace/logs \
    && chmod 777 /workspace -R

COPY demo-0.0.1-SNAPSHOT.war /workspace/basic.war

ENTRYPOINT ["java","-jar","/workspace/basic.war","--docker.ip=${SERVER_IP}"]