package com.example.masearch.util

import android.util.Log
import com.example.masearch.api.vo.ItemOptionDetailVO
import kotlin.math.floor

class AddOptionCalculator {
    //    추옵 / 무기 기본 공마 = 추옵등급
//
//     아케인 // 제네시스 (200제)
//     1추 = 0.61
//     2추 = 0.48
//     3추 = 0.36
//     4추 = 0.26
//     5추 = 0.18
//
//     앱솔(160제)
//     1추 = 0.51
//     2추 = 0.40
//     3추 = 0.30
//     4추 = 0.22
//     5추 = 0.15

//     파프(150제)
//     1추 = 0.41
//     2추 = 0.32
//     3추 = 0.24
//     4추 = 0.17
//     5추 = 0.12

    private val arcaneAddOption: MutableMap<String, String> =
        mutableMapOf("0.61" to "1추", "0.48" to "2추", "0.36" to "3추", "0.26" to "4추", "0.18" to "5추")

    private val absolabsAddOption: MutableMap<String, String> =
        mutableMapOf("0.51" to "1추", "0.40" to "2추", "0.30" to "3추", "0.22" to "4추", "0.15" to "5추")

    private val fafnirAddOption : MutableMap<String, String> =
        mutableMapOf("0.41" to "1추", "0.32" to "2추", "0.24" to "3추", "0.17" to "4추", "0.12" to "5추")

    private val strList = listOf<String>(
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
    private val intList = listOf<String>(
        "매지션",
        "위자드(불,독)",
        "위자드(썬,콜)",
        "클레릭",
        "메이지(불,독)",
        "메이지(썬,콜)",
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

    private val dexList = listOf<String>(
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

    private val lukList = listOf<String>(
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

    private val hpList = listOf<String>("데몬어벤져")
    private val xenonList = listOf<String>("제논")


    fun getAddOption(itemOption: ItemOptionDetailVO, jobClass: String): String {

        return ""
    }

    fun getWeaponAddOption(
        itemBaseOption: ItemOptionDetailVO,
        itemAddOption: ItemOptionDetailVO,
        jobClass: String,
        itemLevel: Int
    ): String {


        val weaponAddOption = if (intList.find { it.startsWith(jobClass) } != null) {
            (itemAddOption.magicPower.toDouble() / itemBaseOption.magicPower.toDouble())
        } else {
            (itemAddOption.attackPower.toDouble() / itemBaseOption.attackPower.toDouble())
        }

        var weaponOption = ""

        when(itemLevel){
            200 -> {
                if (arcaneAddOption[(floor(weaponAddOption * 100) / 100).toString()] != null) {
                    weaponOption = arcaneAddOption[(floor(weaponAddOption * 100) / 100).toString()].toString()
                }
            }
            160 -> {
                if (absolabsAddOption[(floor(weaponAddOption * 100) / 100).toString()] != null) {
                    weaponOption = absolabsAddOption[(floor(weaponAddOption * 100) / 100).toString()].toString()
                }
            }

            150 -> {
                if (fafnirAddOption[(floor(weaponAddOption * 100) / 100).toString()] != null) {
                    weaponOption = fafnirAddOption[(floor(weaponAddOption * 100) / 100).toString()].toString()
                }
            }
        }

        if (itemAddOption.bossDamage != "0") {
            weaponOption += " 보공 ${itemAddOption.bossDamage}%"
        }

        if (itemAddOption.damage != "0") {
            weaponOption += " 데미지 ${itemAddOption.damage}%"
        }

        return weaponOption + ""
    }

}