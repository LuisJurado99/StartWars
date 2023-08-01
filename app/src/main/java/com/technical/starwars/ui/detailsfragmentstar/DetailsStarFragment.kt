package com.technical.starwars.ui.detailsfragmentstar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technical.starwars.R
import com.technical.starwars.databinding.FragmentDetailsBinding
import com.technical.starwars.databinding.FragmentDetailsStarBinding
import com.technical.starwars.ui.viewModel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsStarFragment : Fragment() {


    private var _binding: FragmentDetailsStarBinding? = null
    private val binding: FragmentDetailsStarBinding get() = _binding!!
    private lateinit var viewModel: GeneralViewModel
    private val args by navArgs<DetailsStarFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsStarBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        setInitView()
        setObservers()
    }
    private fun setInitView() {
        viewModel.loadCharacterStart(args.id)
        binding.tbDetailsStar.apply {
            setNavigationIcon(R.drawable.arrow_back)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun setObservers() {
        viewModel.starwarsPeople.observe(viewLifecycleOwner) {
            binding.starPeople = it
        }
    }

    companion object {
        private val TAG: String = DetailsStarFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = DetailsStarFragment()
    }
}