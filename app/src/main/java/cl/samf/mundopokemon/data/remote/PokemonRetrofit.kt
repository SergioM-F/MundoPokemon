package cl.samf.mundopokemon.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRetrofit {

    companion object{
        private const val URL_BASE = "https://pokeapi.co/api/v2/"

        fun getPokemonfitnombres(): PokemonApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(PokemonApi::class.java)
        }
    }
}