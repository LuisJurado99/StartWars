package com.technical.starwars.data.retrofit

import com.technical.starwars.data.entity.ResponseRickMorty
import com.technical.starwars.data.entity.StarWars
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitCharactersPetitions {

    @GET("character")
    suspend fun getAllCharacters(): Response<ResponseRickMorty>
    @GET("all.json")
    suspend fun getAllCharactersStar(): Response<List<StarWars>>

}