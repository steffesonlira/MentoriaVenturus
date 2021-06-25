package com.example.mentoriaventurus.features.pokemon.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mentoriaventurus.databinding.FragmentPokemonBinding
import com.example.mentoriaventurus.features.pokemon.PokemonViewModel
import com.example.mentoriaventurus.features.pokemon.pokemon.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class PokemonFragment : Fragment() {

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonViewModel by viewModels()
    private val disposer = CompositeDisposable()

    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)

        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        fetchPokemons()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposer.dispose()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        pokemonAdapter = PokemonAdapter()

        binding.pokemonsList.apply {
            setHasFixedSize(true)
            adapter = pokemonAdapter
        }
    }

    @ExperimentalCoroutinesApi
    private fun fetchPokemons() {
        val toDispose = viewModel
            .fetchPokemons()
            .subscribe(
                { pokemonAdapter.submitData(lifecycle, it) },
                { Log.e("Error", it.message.toString()) }
            )

        disposer.add(toDispose)
    }
}