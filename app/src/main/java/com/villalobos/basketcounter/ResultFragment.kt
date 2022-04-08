package com.villalobos.basketcounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.villalobos.basketcounter.databinding.ActivityMainBinding
import com.villalobos.basketcounter.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val viewModel : AllViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val scoreA:TextView = binding.scoreA
        val scoreB:TextView = binding.scoreB
        val buttonA:Button = binding.buttonA
        val buttonB:Button = binding.buttonB

        buttonA.setOnClickListener{
            var addA:Int = Integer.parseInt(scoreA.text.toString())
            scoreA.text = addA.plus(3).toString()
        }

        buttonB.setOnClickListener{
            var addB:Int = Integer.parseInt(scoreB.text.toString())
            scoreB.text = addB.plus(3).toString()
        }

        val navController = findNavController()
        binding.actionResult.setOnClickListener{
            val action = ResultFragmentDirections.actionResultFragment2ToFinalResultFragment()
            navController.navigate(action)
        }

    }

}