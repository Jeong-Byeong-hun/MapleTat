package com.example.masearch.util

import android.util.Log
import com.example.masearch.api.vo.ItemOptionDetailVO
import kotlin.math.pow

class AddOptionCalculator {
    //추옵 / 무기 기본 공마 = 추옵등급

    // 1추 = 0.61
    // 2추 = 0.48
    // 3추 = 0.36
    // 4추 = 0.26
    // 5추 = 0.18
    fun getAddOption(itemOption: ItemOptionDetailVO, jobClass: String): String {
        val strList = listOf<String>(
            "초보자",
            "검사",
            "파이터",
            "페이지",
            "스피어맨",
            "크루세이더",
            "나이트",
            "버서커",
            "히어로",
            "팔라딘",
            "다크나이트",
            "소울마스터",
            "미하일",
            "블래스터",
            "데몬슬리어",
            "데몬어벤져",
            "아란",
            "카이저",
            "아델",
            "스트라이커",
            "은월",
            "아크",
            "해적",
            "인파이터",
            "버커니어",
            "바이퍼",
            "캐논슈터",
            "캐논블래스터",
            "캐논마스터",
        )
        val intList = listOf<String>(
            "매지션",
            "위자드(불,독)",
            "위자드(썬,콜)",
            "클레릭",
            "메이지(불,독)",
            "메이지(불,독)",
            "프리스트",
            "아크메이지(불,독)",
            "아크메이지(썬,콜)",
            "비숍",
            "플레임위자드",
            "배틀메이지",
            "에반",
            "루미너스",
            "일리움",
            "라라",
            "키네시스"
        )

        val dexList = listOf<String>(
            "아처",
            "헌터",
            "사수",
            "레인저",
            "저격수",
            "보우마스터",
            "신궁",
            "아처(패스파인더)",
            "에인션트아처",
            "체이서",
            "패스파인더",
            "윈드브레이커",
            "와일드헌터",
            "메르세데스",
            "카인",
            "건슬링거",
            "발키리",
            "캡틴",
            "메카닉",
            "엔젤릭버스터"
        )

        val lukList = listOf<String>(
            "로그",
            "어쌔신",
            "시프",
            "허밋",
            "시프마스터",
            "나이트로드",
            "섀도어",
            "세미듀어러",
            "듀어러",
            "듀얼마스터",
            "슬래셔",
            "듀얼블레이더",
            "나이트워커",
            "팬텀",
            "카데나",
            "칼리",
            "호영",
        )

        val hpList = listOf<String>("데몬어벤져")
        val xenonList = listOf<String>("제논")


        return ""
    }

    fun getWeaponAddOption(itemOption: ItemOptionDetailVO, jobClass: String): String {

        return ""
    }

}