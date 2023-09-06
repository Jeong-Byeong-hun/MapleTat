package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("level")
    val level: String,

    @SerializedName("starforce")
    val starforce: String,

    @SerializedName("soul")
    val soul: String,

    @SerializedName("itemType")
    val itemType: String,

    @SerializedName("STR")
    val STR: MutableList<String>,

    @SerializedName("DEX")
    val DEX: MutableList<String>,

    @SerializedName("INT")
    val INT: MutableList<String>,

    @SerializedName("LUK")
    val LUK: MutableList<String>,

    @SerializedName("공격력")
    val attPower: MutableList<String>,

    @SerializedName("마력")
    val spellPower: MutableList<String>,

    @SerializedName("몬스터 방어력 무시")
    val ignoreDefense: MutableList<String>,

    @SerializedName("가위 사용 가능 횟수")
    val remainScissors : String,

    @SerializedName("잠재옵션")
    val potential: Potential,

    @SerializedName("에디셔널 잠재옵션")
    val additionalPotential: Potential

)
