package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class ItemEquipmentDetailVO(
    @SerializedName("item_equipment_part")
    val itemPart: String,

    @SerializedName("item_equipment_slot")
    val itemSlot: String,

    @SerializedName("item_name")
    val itemName : String,

    @SerializedName("item_icon")
    val itemIcon : String,

    @SerializedName("item_shape_name")
    val itemShapeName : String,

    @SerializedName("item_shape_icon")
    val itemShapeIcon : String,

    @SerializedName("item_total_option")
    val itemTotalOption : ItemOptionDetailVO,
    @SerializedName("item_base_option")
    val itemBaseOption: ItemOptionDetailVO,
    @SerializedName("potential_option_grade")
    val potentialOptionGrade: String?,
    @SerializedName("potential_option_1")
    val potentialOption1: String?,
    @SerializedName("potential_option_2")
    val potentialOption2: String?,
    @SerializedName("potential_option_3")
    val potentialOption3: String?,
    @SerializedName("additional_potential_option_grade")
    val additionalPotentialOptionGrade: String?,
    @SerializedName("additional_potential_option_1")
    val additionalPotentialOption1: String?,
    @SerializedName("additional_potential_option_2")
    val additionalPotentialOption2: String?,
    @SerializedName("additional_potential_option_3")
    val additionalPotentialOption3: String?,
    @SerializedName("equipment_level_increase")
    val equipmentLevelIncrease: Int,
    @SerializedName("item_exceptional_option")
    val itemExceptionalOption: ItemOptionDetailVO,
    @SerializedName("item_add_option")
    val itemAddOption: ItemOptionDetailVO,
    @SerializedName("growth_exp")
    val growthExp: Int,
    @SerializedName("growth_level")
    val growthLevel: Int,
    @SerializedName("scroll_upgrade")
    val scrollUpgrade: String,
    @SerializedName("cuttable_count")
    val cuttableCount: String,
    @SerializedName("golden_hammer_flag")
    val goldenHammerFlag: String,
    @SerializedName("scroll_resilience_count")
    val scrollResilienceCount: String,
    @SerializedName("scroll_upgradeable_count")
    val scrollUpgradeableCount: String,
    @SerializedName("soul_name")
    val soulName: String?,
    @SerializedName("soul_option")
    val soulOption: String?,
    @SerializedName("item_etc_option")
    val itemEtcOption: ItemOptionDetailVO,
    @SerializedName("starforce")
    val starforce: String,
    @SerializedName("starforce_scroll_flag")
    val starforceScrollFlag: String,
    @SerializedName("item_starforce_option")
    val itemStarforceOption: ItemOptionDetailVO,
    @SerializedName("special_ring_level")
    val specialRingLevel: Int
    )
