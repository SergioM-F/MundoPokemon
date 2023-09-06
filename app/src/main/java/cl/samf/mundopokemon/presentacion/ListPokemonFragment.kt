package cl.samf.mundopokemon.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.samf.mundopokemon.R
import cl.samf.mundopokemon.databinding.FragmentListPokemonBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


private const val ARG_PARAM1 = "id"

class ListPokemonFragment : Fragment() {

    private lateinit var binding: FragmentListPokemonBinding
    private val pokemonViewModel: PokemonViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
          //  param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPokemonBinding.inflate(layoutInflater, container, false)
        initAdapter()
        pokemonViewModel.obtenerPokemones()
        return binding.root

    }

    private fun initAdapter() {
        val adapter = AdapterPokemones()
        binding.recyclerPokemonesList.adapter = adapter
        pokemonViewModel.pokemonesLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

}