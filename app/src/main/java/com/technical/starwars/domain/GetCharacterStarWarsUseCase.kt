package com.technical.starwars.domain

import com.technical.starwars.data.CharacterRepository
import com.technical.starwars.data.entity.starwars.StarwarsPeople
import javax.inject.Inject

class GetCharacterStarWarsUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend fun invoke(id: Int): StarwarsPeople {
        return repository.getCharacterStarWars(id)
    }
}