package com.technical.starwars.domain.data

import com.technical.starwars.data.entity.rickmorty.RickMorty
import com.technical.starwars.data.entity.starwars.StarWars

data class People(val id: Int,val name: String?, val image: String?)

fun StarWars.toDomain() = People(id.toInt(), name, image)

fun RickMorty.toDomain() = People(id, name, image)