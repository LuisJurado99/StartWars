package com.technical.starwars.data


import com.technical.starwars.data.retrofit.RetrofitService
import com.technical.starwars.domain.data.People
import com.technical.starwars.domain.data.toDomain
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val retrofitService: RetrofitService){
    suspend fun getAllCharacter(): List<People> {
        return retrofitService.getAllCharactersRickAndMorty().map { it.toDomain() }
    }
    suspend fun getAllCharacterStart(): List<People> {
        return retrofitService.getAllCharactersStarWars().map { it.toDomain() }
    }
}