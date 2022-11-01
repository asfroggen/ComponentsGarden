package com.esaudev.componentsgarden

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
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

        val feelings = resources.getStringArray(R.array.feelings)
        val feelingsMap = createList()
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, feelingsMap.map { it.value })
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.autoCompleteTextView.doOnTextChanged { text, start, before, count ->
            Toast.makeText(requireContext(), getValueFromList(feelingsMap, text.toString()).toString(), Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun createList(): MutableMap<Int, String> {
        val feelings = resources.getStringArray(R.array.feelings)
        val feelingsMap = mutableMapOf<Int, String>()
        feelings.forEachIndexed { index, feeling ->
            feelingsMap[index] = feeling
        }
        return feelingsMap
    }

    private fun getValueFromList(map: MutableMap<Int, String>, selectedValue: String): Int {
        return map.map { it.value }.indexOf(selectedValue)
    }

}