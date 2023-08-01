package com.technical.starwars.ui.personajeslist

import android.os.Bundle
import android.provider.MediaStore.Audio.Genres
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.technical.starwars.R
import com.technical.starwars.databinding.FragmentListPersonajesBinding
import com.technical.starwars.ui.personajeslist.adapter.CharacterAdapter
import com.technical.starwars.ui.viewModel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListPersonajesFragment : Fragment() {

    private var _binding: FragmentListPersonajesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPersonajesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        setAdapters()
    }

    private fun setAdapters() {
        viewModel.allCharacter.observe(viewLifecycleOwner) {listResponse ->
            binding.recyclerMainMorty.apply {
                adapter = CharacterAdapter(listResponse)
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }
    }

    companion object {
        private val TAG: String = ListPersonajesFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = ListPersonajesFragment()
    }
}