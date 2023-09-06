package cl.samf.mundopokemon.data.remote


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {

    @GET("pokemon/?offset=0&limit=1281")
    suspend fun getData() : Response<Pokemon>

}