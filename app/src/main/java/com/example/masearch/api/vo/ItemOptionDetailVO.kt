package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ItemOptionDetailVO(
    @SerializedName("str")
    val str: String,

    @SerializedName("dex")
    val dex: String,

    @SerializedName("int")
    val int: String,

    @SerializedName("luk")
    val luk : String,

    @SerializedName("max_hp")
    val maxHp: String,

    @SerializedName("max_mp")
    val maxMp: String,

    @SerializedName("attack_power")
    val attackPower: String,

    @SerializedName("magic_power")
    val magicPower: String,

    @SerializedName("armor")
    val armor: String,

    @SerializedName("speed")
    val speed: String,

    @SerializedName("jump")
    val jump: String,

    @SerializedName("boss_damage")
    val bossDamage: String,

    @SerializedName("ignore_monster_armor")
    val ignoreMonsterArmor: String,

    @SerializedName("all_stat")
    val allStat: String,

    @SerializedName("damage")
    val damage: String,

    @SerializedName("max_hp_rate")
    val maxHpRate: String,

    @SerializedName("max_mp_rate")
    val maxMpRate: String,

    @SerializedName("base_equipment_level")
    val baseEquipmentLevel : Int
)
