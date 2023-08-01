package com.technical.starwars.ui.detailsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technical.starwars.R
import com.technical.starwars.databinding.FragmentDetailsBinding
import com.technical.starwars.ui.viewModel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!
    private lateinit var viewModel: GeneralViewModel
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
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
        viewModel.loadCharacterRick(args.id)
        binding.tbDetails.apply {
            setNavigationIcon(R.drawable.arrow_back)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun setObservers() {
        viewModel.rickMorty.observe(viewLifecycleOwner) {
            binding.rickMorty = it
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}