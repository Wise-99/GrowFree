# 🌱 GrowFree

## 📖 프로젝트 소개
| 시제품 결과물 | 앱-서버 연결 후 데이터베이스 내용 수신 | 시현 예시 화면 |
|--|--|--|
| ![시제품 결과물](https://file.notion.so/f/s/d636ef52-fe8f-4439-97b8-3b39b02a3edd/Untitled.png?id=daf057af-a285-4676-a244-41908a7ed9dc&table=block&spaceId=4fee607c-9fab-47df-96d0-8ba12808c88d&expirationTimestamp=1687421440027&signature=SV50CI8ujCDP6f0vIUEZoMpLtbQ1r3T5IRsXPQwx7iM&downloadName=Untitled.png) | ![앱 - 서버 연결 후 데이터베이스 내용 수신](https://github.com/Wise-99/GrowFree/assets/90273263/6c247170-0c1f-4ed8-b845-55da7067d82f) | ![](https://file.notion.so/f/s/bda20aed-58a5-48c9-887b-8d61b8efb118/Untitled.png?id=3a585649-cffd-4eac-9cbe-ee248c19003b&table=block&spaceId=4fee607c-9fab-47df-96d0-8ba12808c88d&expirationTimestamp=1687421457030&signature=xo1P-Cgb9l7mmTdTDSL6HGyPXYjVExEOpjIFJtmsXNI&downloadName=Untitled.png) |

> 🌱 앱을 통해 **외부**에서도 식물에게 물을 줄 수 있도록 만든 **원격 시제품** 프로젝트 입니다. 해당 프로젝트로 **2022 경기도 온라인 메이커 경진대회** 본선 진출 하였습니다.
> 
> -   EV3와 라즈베리파이를 이용하여 **원격으로 움직**일 수 있도록 하였습니다.
> -   **라즈베리파이와 앱이 통신**하여 앱의 버튼을 누르면 외부에서도 식물에게 물을 줄 수 있습니다.
> -   앱 버튼을 누름과 동시에 DB에 물을 준 날짜가 저장되며 해당 날짜들은 앱에서 확인할 수 있습니다.

## 📄 담당 업무

-   EV3 설계 및 수정
- 앱 내부 디자인 및 서버와 연결 및 통신
    - **Socket**을 이용하여 InfluxDB와 앱 간의 **TCP 통신** 기능 구현
    - 물주기 버튼 클릭 시 Rasberry Pi 서버에 특정 메세지 전달하여 서버가 날짜를 저장할 수 있도록 함

## 💡 문제 해결 과정
-   서버는 Python 기반이고 앱은 Java 기반인데 통신이 가능할까? 라는 궁금증
    -   양쪽에서 통신을 위해 **Socket**을 사용하여 해결
-   통신 시작과 동시에 앱과 서버에서 **IOException** 발생
    -   **try, catch**를 통해 IOException에 대한 예외 처리를 하여 해결
-   **NetworkOnMainThreadException** 발생
    -   안드로이드 3.0(API 11 이상) 이상에서는 UI Thread를 제외한 Thread에서 네트워크 작업을 수행해야 함 ⇒ **turnOn Thread** 사용
