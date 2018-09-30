FROM openjdk:8-jre-alpine
MAINTAINER Dan Klenin <danila.klenin@gmail.com>
ADD ./build/libs/carservice-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/carservice-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=container"]
EXPOSE 8080