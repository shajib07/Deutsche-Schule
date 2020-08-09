package com.atahar.germanschool.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atahar.germanschool.adapter.LetterListAdapter
import com.atahar.germanschool.viewmodel.LetterListViewModel
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {

    private lateinit var viewModel: LetterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentLetterListBinding>(
            inflater,
            R.layout.fragment_letter_list,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LetterListViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = LetterListAdapter()
        adapter.data = viewModel.letterList.value ?: emptyList()

        binding.letterListRv.adapter = adapter

        return binding.root
    }
}