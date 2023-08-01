package com.technical.starwars.domain

import com.technical.starwars.data.CharacterRepository
import com.technical.starwars.data.entity.ResponseRickMorty
import retrofit2.Response
import javax.inject.Inject

class GetAllCharactesUseCase @Inject constructor(private val repository: CharacterRepository) {
     suspend fun invoke(): Response<ResponseRickMorty> {
         return repository.getAllCharacter()
     }
}