package com.technical.starwars.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technical.starwars.domain.GetAllCharactesUseCase
import com.technical.starwars.domain.data.People
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class GeneralViewModel @Inject constructor(private val getAllCharactesUseCase: GetAllCharactesUseCase) :
    ViewModel() {

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

    fun setNewQuery(query: String) {
        if (query != _searchQuery.value) {
            _searchQuery.value = query
            loadGetAllCharacter()
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