package cl.samf.mundopokemon.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.samf.mundopokemon.data.local.PokemonEntity
import cl.samf.mundopokemon.databinding.ActivityMainBinding
import cl.samf.mundopokemon.databinding.ItemListBinding
import coil.load

class AdapterPokemones : RecyclerView.Adapter<AdapterPokemones.PokemonesViewHolder>() {
    lateinit var binding: ItemListBinding
    private val listItemPokemones = mutableListOf<PokemonEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonesViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemPokemones.size
    }

    override fun onBindViewHolder(holder: PokemonesViewHolder, position: Int) {
        val pokemon = listItemPokemones[position]
        holder.bind(pokemon)
    }

    fun setData(pokemon: List<PokemonEntity>) {
        this.listItemPokemones.clear()
        this.listItemPokemones.addAll(pokemon)
        notifyDataSetChanged()
    }

    class PokemonesViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: PokemonEntity) {
            binding.textViewList.text = pokemon.name
            val urlOriginal = pokemon.url
            val urlWithoutTrailingSlah = urlOriginal.trimEnd('/')
            val extractNumber = urlWithoutTrailingSlah.split("/").lastOrNull()
            if (extractNumber != null) {
                val newImageUrl =
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$extractNumber.png"
                binding.imageView.load(newImageUrl)
            }


        }

    }
}