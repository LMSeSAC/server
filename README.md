# server
LMSeSAC server code

# 필수작업
1. application.properties 설정
2. 코드 컨벤션 적용
    ```
    - IntelliJ -> File -> Settings -> Editor -> Code Style 접속
    - Schema -> Import Schema -> naver-code.xml 선택
    ```

    ```
    - IntelliJ -> File -> Settings -> Tools -> Action on Save
    - Reformat code 와 Optimize imports 체크
    ```
3. `env` 설정
    - 플러그인에서 EnvFile 다운로드 및 설치
    - Applicaion > 구성편집( Edit Configurations ) > Enable EnvFile 체크 > 아래에서 dev.env 파일 선택