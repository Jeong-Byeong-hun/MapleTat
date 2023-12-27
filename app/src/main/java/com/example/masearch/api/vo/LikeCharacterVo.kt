package com.example.masearch.api.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "like_table")
data class LikeCharacterVo(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val nickName: String,
    val imgUrl: String
)
