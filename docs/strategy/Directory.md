# Introduce
GitHub에서 재사용하기 위해 제작한 Directory 기본 양식이다.

### Sample Template
```markdown
src
├── main
│   ├── java.com.example.commonspringboot
│   │   ├── cache                # 캐시 전략/설정(@Cacheable, CacheManager 등)
│   │   ├── commons              # 공통 유틸/DTO/응답 래퍼 등(재사용 가능한 제네릭 클래스)
│   │   │   └── CommonResponse.java     # 표준 API 응답 포맷
│   │   ├── config               # 설정/프로퍼티 바인딩, Web/MVC/Swagger/DB 설정
│   │   ├── constants            # 상수/Enum, 코드/키 값 모음
│   │   ├── exception            # 전역 예외 처리 계층
│   │   │   ├── errorcode        # 도메인별 ErrorCode Enum
│   │   │   ├── *ErrorCode.java  # 에러코드 인터페이스(또는 공통 Enum)
│   │   │   ├── ControlledException.java    # 비즈니스 예외(의도적) 베이스 클래스
│   │   │   ├── ErrorMessage.java           # 에러 응답/메시지 DTO
│   │   │   └── GlobalExceptionHandler.java # @ControllerAdvice 전역 예외 처리
│   │   ├── routers              # API 계층(Controller/Service/Repository + DTO)
│   │   │   └── *
│   │   │       ├── {TableName}.java       # JPA 엔티티 또는 레코드(선택)
│   │   │       ├── *Controller.java       # REST 컨트롤러
│   │   │       ├── *Service.java          # 서비스(트랜잭션/비즈니스 로직)
│   │   │       ├── *Repository.java       # JPA/JDBC 리포지토리
│   │   │       └── *DTO.java              # 요청/응답 DTO
│   │   ├── security             # 인증/인가, PasswordEncoder/Filter/Config
│   │   ├── util                 # 범용 유틸리티(시계, 문자열, 암호화 래퍼 등)
│   │   ├── validation           # 커스텀 검증 애너테이션/Validator
│   │   └── CommonSpringbootApplication.java # Spring Boot 부트스트랩
│   └── resources
│       └── application.properties # 환경설정(프로필 분리 권장: application.yml 등)
└── test # 단위, 통합 테스트 진행
```