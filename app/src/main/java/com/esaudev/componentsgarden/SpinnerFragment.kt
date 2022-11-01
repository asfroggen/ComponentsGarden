package com.esaudev.componentsgarden

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
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

        val feelings = createMap()
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, feelings.map { it.value })

        binding.autoCompleteTextView.apply {
            setAdapter(arrayAdapter)

            doOnTextChanged { selectedFeeling, _, _, _ ->
                Toast.makeText(requireContext(), getValueFromMap(feelings, selectedFeeling.toString()).toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.testSpinner.setOnClickListener {
            Toast.makeText(requireContext(), getValueFromMap(feelings, binding.autoCompleteTextView.text.toString()).toString(), Toast.LENGTH_SHORT).show()
        }
        
        return binding.root
    }

    private fun createMap(): MutableMap<Int, String> {
        val feelings = resources.getStringArray(R.array.feelings)
        val feelingsMap = mutableMapOf<Int, String>()
        feelings.forEachIndexed { index, feeling ->
            feelingsMap[index] = feeling
        }
        return feelingsMap
    }

    private fun getValueFromMap(feelingMap: MutableMap<Int, String>, selectedFeeling: String): Int {
        return feelingMap.map { it.value }.indexOf(selectedFeeling)
    }
}