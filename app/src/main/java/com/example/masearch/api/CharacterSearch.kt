package com.example.masearch.api

import javax.inject.Inject

class CharacterSearch @Inject constructor(private val searchService: SearchService) {
    suspend fun getCharacterInfo(id: Map<String, String>) =
        searchService.getCharacter(id)
}