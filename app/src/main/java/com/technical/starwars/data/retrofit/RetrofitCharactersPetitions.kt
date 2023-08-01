package com.technical.starwars.data.retrofit

import com.technical.starwars.data.entity.rickmorty.ResponseRickMorty
import com.technical.starwars.data.entity.rickmorty.RickMorty
import com.technical.starwars.data.entity.starwars.StarWars
import com.technical.starwars.data.entity.starwars.StarwarsPeople
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitCharactersPetitions {

    @GET("character")
    suspend fun getAllCharacters(): Response<ResponseRickMorty>
    @GET("all.json")
    suspend fun getAllCharactersStar(): Response<List<StarWars>>
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<RickMorty>
    @GET("id/{id}.json")
    suspend fun getCharacterStar(@Path("id") id: Int): Response<StarwarsPeople>

}