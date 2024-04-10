# TODO: docker 공부해보고 3주차에 다시 얘기해보기
# 멀티스테이징 빌드
# - jre/jdk/jar
# - 빌드를 어디서하는지 결정해보세요
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]