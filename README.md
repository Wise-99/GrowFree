# GrowFree

## 📖 프로젝트 소개
| 시제품 결과물 | 앱-서버 연결 후 데이터베이스 내용 수신 | 시현 예시 화면 |
|--|--|--|
| ![시제품 결과물](https://file.notion.so/f/s/d636ef52-fe8f-4439-97b8-3b39b02a3edd/Untitled.png?id=daf057af-a285-4676-a244-41908a7ed9dc&table=block&spaceId=4fee607c-9fab-47df-96d0-8ba12808c88d&expirationTimestamp=1687421440027&signature=SV50CI8ujCDP6f0vIUEZoMpLtbQ1r3T5IRsXPQwx7iM&downloadName=Untitled.png) | ![앱 - 서버 연결 후 데이터베이스 내용 수신](https://file.notion.so/f/s/da42c354-475e-4c73-85b0-c257bb4412ad/Untitled.png?id=f735f2b7-1b58-4c27-ad53-61b8b32ccdf4&table=block&spaceId=4fee607c-9fab-47df-96d0-8ba12808c88d&expirationTimestamp=1687421449743&signature=nmDOV3aKM6jNT5WSCr4HL-Ccdmus97iKB1zyrInkMWk&downloadName=Untitled.png) | ![](https://file.notion.so/f/s/bda20aed-58a5-48c9-887b-8d61b8efb118/Untitled.png?id=3a585649-cffd-4eac-9cbe-ee248c19003b&table=block&spaceId=4fee607c-9fab-47df-96d0-8ba12808c88d&expirationTimestamp=1687421457030&signature=xo1P-Cgb9l7mmTdTDSL6HGyPXYjVExEOpjIFJtmsXNI&downloadName=Untitled.png) |

> 🌱 앱을 통해 **외부**에서도 식물에게 물을 줄 수 있도록 만든 **원격 시제품** 프로젝트 입니다. 해당 프로젝트로 **2022 경기도 온라인 메이커 경진대회** 본선 진출 하였습니다.
> 
> -   EV3와 라즈베리파이를 이용하여 **원격으로 움직**일 수 있도록 하였습니다.
> -   **라즈베리파이와 앱이 통신**하여 앱의 버튼을 누르면 외부에서도 식물에게 물을 줄 수 있습니다.
> -   앱 버튼을 누름과 동시에 DB에 물을 준 날짜가 저장되며 해당 날짜들은 앱에서 확인할 수 있습니다.

## 📄 담당 업무

-   EV3 설계 및 수정
-   앱 내부 디자인 및 서버와 연결 및 통신
-   물을 준 날짜를 저장하여 서버에 송신
-   데이터베이스에 저장되어 있는 날짜를 앱으로 수신

## 💡 깨달은 점

-   서버와의 통신 시에는 **IOException와 try, catch**를 통해 예외 처리를 반드시 해야 함
-   안드로이드 3.0(API 11 이상) 이상에서는 UI 스레드를 제외한 스레드에서 네트워크 작업을 수행해야 함, **NetworkOnMainThreadException**이 발생할 수 있음 → turnOn() 스레드를 이용함
