package cl.samf.mundopokemon.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 1)

abstract class PokemonDataBase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao

    companion object{
        @Volatile
        private var INSTANCE: PokemonDataBase? = null

        fun getDatabase (context: Context): PokemonDataBase {
            val temInstance = INSTANCE
            if (temInstance != null) {
                 return temInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDataBase::class.java,
                    "pokemon_ddbb"
                ).build()

                INSTANCE= instance
                return instance
            }
        }
    }
}