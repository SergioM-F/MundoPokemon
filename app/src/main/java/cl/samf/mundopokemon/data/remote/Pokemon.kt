package cl.samf.mundopokemon.data.remote

import cl.samf.mundopokemon.data.local.PokemonEntity


data class Poke(val name: String, val url: String)
data class Pokemon(
    val results: List<Poke>

)

