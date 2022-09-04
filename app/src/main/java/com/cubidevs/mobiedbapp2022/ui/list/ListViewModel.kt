package com.cubidevs.mobiedbapp2022.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.server.freegamesrepository.FreeGamesRepository
import com.cubidevs.mobiedbapp2022.server.model.FreeGame
import com.cubidevs.mobiedbapp2022.server.model.FreeGamesList
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val gamesRepository = FreeGamesRepository()

    private val _gamesLoaded : MutableLiveData<ArrayList<FreeGame>> = MutableLiveData()
    val gamesLoaded: LiveData<ArrayList<FreeGame>> = _gamesLoaded

    fun getMovies() {
        viewModelScope.launch {
            val gamesList : FreeGamesList = gamesRepository.getGames()
            _gamesLoaded.postValue(gamesList.games as ArrayList<FreeGame>)
        }
    }
}