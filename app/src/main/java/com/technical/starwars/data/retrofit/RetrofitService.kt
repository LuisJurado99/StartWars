package com.technical.starwars.data.retrofit

import android.util.Log
import com.technical.starwars.data.entity.RickMorty
import com.technical.starwars.data.entity.StarWars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitService @Inject constructor(private val api: RetrofitCharactersPetitions){

    suspend fun getAllCharactersRickAndMorty(): List<RickMorty> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharacters()
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getAllCharactersStarWars(): List<StarWars> {
        return withContext(Dispatchers.IO) {
            api.getAllCharactersStar().body() ?: emptyList()
        }
    }
}