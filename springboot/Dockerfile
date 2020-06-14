FROM openjdk:8-jre-slim
MAINTAINER jiangxiaobai

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/springboot*.jar /app.jar

ENTRYPOINT ["sh","-c","java -jar /app.jar $PARAMS"]
