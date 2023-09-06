package cl.samf.mundopokemon.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.samf.mundopokemon.data.Repository
import cl.samf.mundopokemon.data.local.PokemonDataBase
import cl.samf.mundopokemon.data.local.PokemonEntity
import cl.samf.mundopokemon.data.remote.PokemonApi
import cl.samf.mundopokemon.data.remote.PokemonRetrofit
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application): AndroidViewModel(application) {

    private val repository: Repository

    fun pokemonesLiveData() = repository.obtenerPokemonEntity()

    init {
        val pokemonApi = PokemonRetrofit.getPokemonfitnombres()
        val pokemonDataBase = PokemonDataBase.getDatabase(application).getPokemonDao()
        repository = Repository(pokemonApi, pokemonDataBase)
    }
    fun obtenerPokemones() = viewModelScope.launch {
        repository.obtenerPokemones()
    }


}

