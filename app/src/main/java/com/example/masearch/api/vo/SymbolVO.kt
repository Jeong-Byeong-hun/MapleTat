package com.example.masearch.api.vo

import com.google.gson.annotations.SerializedName

data class SymbolVO(
    @SerializedName("symbol_name")
    val symbolName: String,
    @SerializedName("symbol_icon")
    val symbolIcon: String,
    @SerializedName("symbol_description")
    val symbolDescription: String,
    @SerializedName("symbol_force")
    val symbolForce: String,
    @SerializedName("symbol_level")
    val symbolLevel: Int,
    @SerializedName("symbol_str")
    val symbolStr: String,
    @SerializedName("symbol_dex")
    val symbolDex: String,
    @SerializedName("symbol_int")
    val symbolInt: String,
    @SerializedName("symbol_luk")
    val symbolLuk: String,
    @SerializedName("symbol_hp")
    val symbolHp: String,
    @SerializedName("symbol_growth_count")
    val symbolGrowthCount: Int,
    @SerializedName("symbol_require_growth_count")
    val symbolRequireGrowthCount: Int
)



