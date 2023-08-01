package com.technical.starwars.data

import com.technical.starwars.data.entity.ResponseRickMorty
import com.technical.starwars.data.retrofit.RetrofitCharactersPetitions
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val retrofitCharactersPetitions: RetrofitCharactersPetitions){
    suspend fun getAllCharacter(): Response<ResponseRickMorty> = retrofitCharactersPetitions.getAllCharacters()
}