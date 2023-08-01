package com.technical.starwars.domain.data

import com.technical.starwars.data.entity.RickMorty
import com.technical.starwars.data.entity.StarWars

data class People(val name: String?, val image: String?)

fun StarWars.toDomain() = People(name, image)

fun RickMorty.toDomain() = People(name, image)