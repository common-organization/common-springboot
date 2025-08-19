# 빌드 스테이지: Gradle로 애플리케이션 JAR 생성
FROM eclipse-temurin:25-jdk AS builder

# 패키지 설치 (xargs 등 필요 시)
# - Debian/Ubuntu 계열이므로 apt-get 사용
# - --no-install-recommends 로 불필요한 패키지 제외
# - 캐시 축소를 위해 리스트 삭제
RUN apt-get update \
 && apt-get install -y --no-install-recommends findutils \
 && rm -rf /var/lib/apt/lists/*

# 작업 디렉터리
WORKDIR /app

# Gradle 캐시 최적화를 위해 래퍼/설정 파일을 먼저 복사
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle

# 애플리케이션 소스 복사
COPY src/ src/

# Gradle Wrapper 실행 권한 부여
RUN chmod +x gradlew

# 애플리케이션 빌드 (bootJar 생성)
# 필요시 --no-daemon 추가
RUN ./gradlew --no-daemon bootJar


# 실행 스테이지: 빌드된 JAR만 포함한 경량 런타임 이미지
FROM eclipse-temurin:25-jdk
# 참고: 더 가벼운 런타임이 필요하면 다음과 같이 JRE 이미지를 고려할 수 있습니다.
# FROM eclipse-temurin:25-jre

# 작업 디렉터리
WORKDIR /app

# 빌드 산출물(JAR)만 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션 포트
EXPOSE 8080

# 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]

# 타임존 설정 (필요 시 tzdata 설치하여 시스템 타임존까지 반영 가능)
ENV TZ=Asia/Seoul
