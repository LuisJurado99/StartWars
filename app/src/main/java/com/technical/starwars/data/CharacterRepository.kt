package com.technical.starwars.data


import com.technical.starwars.data.entity.rickmorty.RickMorty
import com.technical.starwars.data.entity.starwars.StarwarsPeople
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

    suspend fun getCharacterRick(id: Int): RickMorty {
        return  retrofitService.getCharacter(id)
    }
    suspend fun getCharacterStarWars(id: Int): StarwarsPeople {
        return  retrofitService.getCharacterStarWars(id)
    }
}