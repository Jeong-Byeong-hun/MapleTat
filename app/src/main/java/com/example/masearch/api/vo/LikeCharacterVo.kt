package com.example.masearch.api.vo

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "like_table", indices = [Index(value = ["nickName"], unique = true)])
data class LikeCharacterVo(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val nickName: String,
    val imgUrl: String
)
