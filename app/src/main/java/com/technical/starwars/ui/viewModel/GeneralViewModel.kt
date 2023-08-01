package com.technical.starwars.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technical.starwars.data.entity.RickMorty
import com.technical.starwars.domain.GetAllCharactesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class GeneralViewModel @Inject constructor(private val getAllCharactesUseCase: GetAllCharactesUseCase) : ViewModel() {

    private var _allCharacter: MutableLiveData<List<RickMorty>> = MutableLiveData(
        listOf()
    )
    val allCharacter: LiveData<List<RickMorty>> get() = _allCharacter


    private fun loadGetAllCharacter() {
        viewModelScope.launch {
            val response = getAllCharactesUseCase.invoke()

            if (response.isSuccessful){
                Log.e(GeneralViewModel::class.java.simpleName, "loadGetAllCharacter: ${response.body()?.results}", )
                _allCharacter.postValue(getAllCharactesUseCase.invoke().body()?.results)
            } else{
                Log.e(GeneralViewModel::class.java.simpleName, "loadGetAllCharacter: com.technical.starwars.data.entity.Character", )
            }
        }
    }

    init {
        loadGetAllCharacter()
    }

}