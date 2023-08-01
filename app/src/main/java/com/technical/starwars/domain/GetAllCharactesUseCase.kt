package com.technical.starwars.domain

import com.technical.starwars.BuildConfig
import com.technical.starwars.data.CharacterRepository
import com.technical.starwars.domain.data.People
import javax.inject.Inject

class GetAllCharactesUseCase @Inject constructor(private val repository: CharacterRepository) {
     suspend fun invoke(): List<People> {
         return if (BuildConfig.BUILD_TYPE.equals("debug")){
             repository.getAllCharacter()
         } else
             repository.getAllCharacterStart()
     }
}