package com.technical.starwars.data.retrofit

import com.technical.starwars.data.entity.rickmorty.RickMorty
import com.technical.starwars.data.entity.starwars.StarWars
import com.technical.starwars.data.entity.starwars.StarwarsPeople
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

    suspend fun getCharacterStarWars(id:Int): StarwarsPeople {
        return withContext(Dispatchers.IO) {
            api.getCharacterStar(id).body() ?: StarwarsPeople(id = 0)
        }
    }
    suspend fun getCharacter(id:Int): RickMorty {
        return withContext(Dispatchers.IO) {
            api.getCharacter(id).body() ?: RickMorty(id = 0)
        }
    }

}