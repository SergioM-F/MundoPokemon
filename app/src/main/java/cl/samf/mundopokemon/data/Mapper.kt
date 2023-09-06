package cl.samf.mundopokemon.data

import cl.samf.mundopokemon.data.local.PokemonEntity

fun String.toEntity(name: String): PokemonEntity =  PokemonEntity(name, this)