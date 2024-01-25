# MapleTat 
자신의 메이플 캐릭터를 검색해보자 !


## 개발기간
* 2023.11 ~ 2024.01


### 개발환경
- Android Studio - Android Studio Giraffe | 2022.3.1 Patch 1
- AGP Version - 8.1.1
- Gradle Version - 8.3
- CompileSdk - 34
- minSdk - 28
- targetSdk - 33

**Tech Stack:**

- Kotlin
- Jetpack Compose
- Glide
- Hilt
- Coroutine 
- Retrofit2
- Jetpack Compose Navigation
- Room
- MVVM

---

### 메인화면


<div style="float:left; margin-right:10px;">
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/14dddb3d-0fba-4680-8a55-c098827c07a3" alt="메인 화면" width="300">

  
  메인화면입니다. 메인화면은 캐릭터를 검색하는 검색창과 최근 검색 기록, 즐겨찾기를 추가한 캐릭터들을 확인 할 수 있습니다.
</div>


<div style="float:left; margin-right:10px;">
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/c460bef2-fdb6-4139-b2a2-16fd7a507c08" alt="스탯" width="300">

  
  검색 결과 화면입니다. Retrofit2를 이용해 HTTP 통신의 결과를 보여줍니다.


  캐릭터가 기본적으로 가지고 있는 스탯류와 장비 아이템을 볼 수 있습니다.


  상단의 별을 클릭을 하게되면 캐릭터가 즐겨찾기에 추가가 됩니다.

  <br>
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/e4aaecc6-8fdf-4224-827a-adc95d8ddd14" alt="장비아이템" width="300">
  

  장착한 아이템의 정보를 볼 수 있습니다.

  <br>
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/d42e4b78-fa8d-4130-b061-92fbddf32e6a" alt="장비아이템 상세정보" width="300">


  장착한 아이템의 상세한 정보를 볼 수 있습니다.

  <br>
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/e38c7ca7-6dab-4250-aef0-6ba18c385c07" alt="최근 검색 기록" width="300">
  

  최근 검색한 캐릭터들의 기록입니다. Room을 이용해 데이터를 저장하고 업데이트 하고 있습니다.

  <br>
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/c1338283-b215-4971-aebe-a9e6e7bf3eb8" alt="즐겨찾기" width="300">
  

  즐겨찾기를 추가한 캐릭터들의 리스트를 볼 수 있습니다. 클릭 시 바로 해당 캐릭터의 스탯을 확인 할 수 있습니다. 최근 검색 기록과 마찬가지로 Room을 이용해 데이터를 저장, 업데이트 하고 있습니다.

  <br>
  <img src="https://github.com/Jeong-Byeong-hun/MaSearch/assets/46989392/31159dbe-4c67-40c8-90e2-ef0629b49560" alt="즐겨찾기" width="300">
  

  마지막으로 캐릭터를 찾을 수 없을 때 나오는 에러메세지입니다. 
  
  
  현재 넥슨측에서 제공하는 API를 이용하고 있으며 해당 API의 결과를 받기 위해서 캐릭터의 최근 접속일이 23.12.21 이후인 캐릭터들만 조회가 가능합니다.

  
</div>


---


