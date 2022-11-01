package com.esaudev.componentsgarden

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.esaudev.componentsgarden.databinding.FragmentSpinnerBinding

class SpinnerFragment : Fragment() {

    private var _binding: FragmentSpinnerBinding? = null
    private val binding: FragmentSpinnerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSpinnerBinding.inflate(inflater, container, false)

        
        return binding.root
    }

}