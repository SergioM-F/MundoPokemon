package cl.samf.mundopokemon.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemones (pokemonEntity: List<PokemonEntity>)

    @Query("select * from pokemon_table ORDER BY name ASC")
    fun getPokemon() : LiveData<List<PokemonEntity>>


}