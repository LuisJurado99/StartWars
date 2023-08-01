package com.technical.starwars.ui.personajeslist

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.technical.starwars.BuildConfig
import com.technical.starwars.databinding.FragmentListPersonajesBinding
import com.technical.starwars.domain.data.People
import com.technical.starwars.ui.personajeslist.adapter.CharacterAdapter
import com.technical.starwars.ui.viewModel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListPersonajesFragment : Fragment(), CharacterAdapter.OnClickCharacter {

    private var _binding: FragmentListPersonajesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPersonajesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        setAdapters()
        setMenu()
    }

    private fun setMenu() {
        binding.apply {
            toolbarSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.setNewQuery(toolbarSearch.query.toString())
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.setNewQuery(toolbarSearch.query.toString())
                    return true
                }

            })
        }
    }

    private fun setAdapters() {
        viewModel.listShowFilter.observe(viewLifecycleOwner) { listResponse ->
            binding.recyclerMainMorty.apply {
                adapter = CharacterAdapter(listResponse, this@ListPersonajesFragment)
                layoutManager =
                    if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                        GridLayoutManager(requireContext(), 2)
                    else
                        GridLayoutManager(requireContext(), 4)
            }
        }
    }

    override fun clickShowDetails(people: People) {
        val action = if (BuildConfig.BUILD_TYPE.equals("debug")) {
            ListPersonajesFragmentDirections.actionListPersonajesFragmentToDetailsFragment(people.id)
        } else {
            ListPersonajesFragmentDirections.actionListPersonajesFragmentToDetailsStarFragment(people.id)
        }
        findNavController().navigate(action)
    }

    companion object {
        private val TAG: String = ListPersonajesFragment::class.java.simpleName

        @JvmStatic
        fun newInstance() = ListPersonajesFragment()
    }

}