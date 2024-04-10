# 멀티스테이징 빌드
# - jre/jdk/jar
# - 빌드
# - disk 용량

# CMD vs ENTRYPOINT

FROM  eclipse-temurin:17-jdk-jammy as builder

COPY . /app
WORKDIR /app

RUN ./gradlew clean -x test build

FROM eclipse-temurin:17-jre-jammy as runner

COPY --from=builder /app/build/libs/codestartup-1.0.jar /app/app.jar

#CMD ["java", "-jar", "-Dspring.profiles.active=sandbox", "/app/app.jar"]
ENTRYPOINT ["java","-jar", "/app/app.jar"]
# pid = process id
# graceful shutdown
# 좀 더 알아보고 싶다면... dumb-init

# warm up
# byte code -> 기계어로 바꿔야함
# JIT (Just In Time) 컴파일러
# - 많이 사용된 함수를 미리 기계어로 바꿔 놓는다. (캐싱)
# - warm up이라는건 인위적으로 많이 함수를 실행시킨다 (api controller 호출)
# https://engineering.linecorp.com/ko/blog/apply-warm-up-in-spring-boot-and-kubernetes


