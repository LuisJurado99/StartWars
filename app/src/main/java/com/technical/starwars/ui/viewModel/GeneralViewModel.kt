package com.technical.starwars.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technical.starwars.data.entity.rickmorty.RickMorty
import com.technical.starwars.data.entity.starwars.StarwarsPeople
import com.technical.starwars.domain.GetAllCharactesUseCase
import com.technical.starwars.domain.GetCharacterRickUseCase
import com.technical.starwars.domain.GetCharacterStarWarsUseCase
import com.technical.starwars.domain.data.People
import com.technical.starwars.ui.detailsfragmentstar.DetailsStarFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class GeneralViewModel @Inject constructor(
    private val getAllCharactesUseCase: GetAllCharactesUseCase,
    private val getCharacterRickUseCase: GetCharacterRickUseCase,
    private val getCharacterStarWarsUseCase: GetCharacterStarWarsUseCase

    ) : ViewModel() {

    private var _allCharacter: MutableLiveData<List<People>> = MutableLiveData(
        listOf()
    )
    private val allCharacter: LiveData<List<People>> get() = _allCharacter

    private var _listShowFilter: MutableLiveData<List<People>> = MutableLiveData(
        listOf()
    )
    val listShowFilter: LiveData<List<People>> get() = _listShowFilter

    private var _searchQuery: MutableLiveData<String> = MutableLiveData("")
    val searchQuery: LiveData<String> get() = _searchQuery

    private var _rickMorty: MutableLiveData<RickMorty> = MutableLiveData()
    val rickMorty: LiveData<RickMorty> get() = _rickMorty

    private var _starwarsPeople: MutableLiveData<StarwarsPeople?> = MutableLiveData()
    val starwarsPeople: MutableLiveData<StarwarsPeople?> get() = _starwarsPeople

    fun setNewQuery(query: String) {
        if (query != _searchQuery.value) {
            _searchQuery.value = query
            loadGetAllCharacter()
        }
    }

    fun loadCharacterStart(id: Int) {
        viewModelScope.launch {
            val response = getCharacterStarWarsUseCase.invoke(id)
            Log.e(GeneralViewModel::class.java.simpleName, "setObservers: $response")
            _starwarsPeople.value = response
        }
    }
    fun loadCharacterRick(id :Int) {
        viewModelScope.launch {
            _rickMorty.value = getCharacterRickUseCase.invoke(id)
        }
    }

    private fun loadGetAllCharacter() {
        viewModelScope.launch {
            if (allCharacter.value.isNullOrEmpty()) {
                _allCharacter.value = getAllCharactesUseCase.invoke()
            }
            if (searchQuery.value.isNullOrEmpty()) {
                _listShowFilter.postValue(_allCharacter.value)
            } else {
                _listShowFilter.postValue(_allCharacter.value?.filter {
                    it.name?.uppercase()?.contains(
                        searchQuery.value?.uppercase() ?: ""
                    ) == true
                })
            }
        }
    }

    init {
        loadGetAllCharacter()
    }

}