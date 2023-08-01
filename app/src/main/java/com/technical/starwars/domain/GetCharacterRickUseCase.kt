package com.technical.starwars.domain

import com.technical.starwars.data.CharacterRepository
import com.technical.starwars.data.entity.rickmorty.RickMorty
import javax.inject.Inject

class GetCharacterRickUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend fun invoke(id:Int): RickMorty {
        return repository.getCharacterRick(id)
    }
}