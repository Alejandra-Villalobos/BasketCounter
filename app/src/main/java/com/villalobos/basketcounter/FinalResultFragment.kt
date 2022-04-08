package com.villalobos.basketcounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.villalobos.basketcounter.databinding.FragmentFinalResultBinding
import com.villalobos.basketcounter.databinding.FragmentResultBinding


class FinalResultFragment : Fragment() {
    private lateinit var binding : FragmentFinalResultBinding
    private val viewModel : AllViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_final_result, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        if(Integer.parseInt(viewModel.scoreA.value)>(Integer.parseInt(viewModel.scoreB.value))){
            viewModel.winner.value = "Team A"
        }
        else if(Integer.parseInt(viewModel.scoreA.value)<(Integer.parseInt(viewModel.scoreB.value))){
            viewModel.winner.value = "Team B"
        }
        else{
            viewModel.winner.value = "Empate"
        }
    }

}