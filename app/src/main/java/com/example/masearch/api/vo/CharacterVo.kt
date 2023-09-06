package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class CharacterVo(
    @SerializedName("name")
    val name: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("월드")
    val world: String,
    @SerializedName("직업")
    val role: String,
    @SerializedName("길드")
    val guild: String,
    @SerializedName("스탯공격력")
    val statAttPower: MutableList<String>,
    @SerializedName("HP")
    val hp: String,
    @SerializedName("MP")
    val mp: String,
    @SerializedName("STR")
    val str: String,
    @SerializedName("DEX")
    val dex: String,
    @SerializedName("INT")
    val int: String,
    @SerializedName("LUK")
    val luk: String,
    @SerializedName("크리티컬 데미지")
    val criticalDamage: String,
    @SerializedName("보스공격력")
    val boseOffensePower: String,
    @SerializedName("방어율무시")
    val ignoreDefense: String,
    @SerializedName("아케인포스")
    val arcaneForce: String,
    @SerializedName("어빌리티")
    val ability: AbilityVo,
    @SerializedName("하이퍼스탯")
    val hyperStats: MutableList<String>,
)