package cl.samf.mundopokemon.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.samf.mundopokemon.data.local.PokemonDao
import cl.samf.mundopokemon.data.local.PokemonEntity
import cl.samf.mundopokemon.data.remote.PokemonApi

class Repository(private val pokemonApi: PokemonApi, private val pokemonDao: PokemonDao) {

    fun obtenerPokemonEntity(): LiveData<List<PokemonEntity>> = pokemonDao.getPokemon()
    suspend fun obtenerPokemones() {
        try {

            val response = pokemonApi.getData()
            if (response.isSuccessful) {
                val pokemones = response.body()
                pokemones?.let { pokemonList->
                    val pokemonEntities = pokemonList.results.map { poke ->
                        PokemonEntity(poke.name, poke.url)
                    }
                    pokemonDao.insertAllPokemones(pokemonEntities)
                    Log.d("ok", "${response.message()}")
                }


            } else {
                Log.e("repository", response.errorBody().toString())
            }


    } catch (e: Exception)
    {
        Log.e("API_ERROR", "Error al conectarse a la API: ${e.message}")
    }
}

}





