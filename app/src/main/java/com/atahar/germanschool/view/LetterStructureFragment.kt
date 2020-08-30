package com.atahar.germanschool.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.FragmentLetterStructureBinding

class LetterStructureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLetterStructureBinding>(
            inflater,
            R.layout.fragment_letter_structure,
            container,
            false
        )


        return binding.root
    }
}