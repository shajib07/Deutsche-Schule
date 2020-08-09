package com.atahar.germanschool.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.atahar.germanschool.adapter.LetterListAdapter
import com.atahar.germanschool.viewmodel.LetterListViewModel
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.FragmentLetterListBinding
import com.atahar.germanschool.db.GermanSchoolDatabase
import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.listener.LetterListClickListener
import com.atahar.germanschool.repository.LettersShortRepository
import com.atahar.germanschool.viewmodel.LetterListViewModelFactory

class LetterListFragment : Fragment(), LetterListClickListener {

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

        val application = requireNotNull(this.activity).application
        val repository = LettersShortRepository.getInstance(
            GermanSchoolDatabase.getInstance(application).lettersShortDao
        )

        val factory = LetterListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(LetterListViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = LetterListAdapter(this)

        viewModel.getShortLetters().observe(viewLifecycleOwner, Observer {
            if (it != null && it.isNotEmpty()) {
                viewModel.shortLetters.value = it
                adapter.data = viewModel.shortLetters.value ?: emptyList()
            }
        })


        binding.letterListRv.adapter = adapter

        return binding.root
    }

    override fun onItemClick(letterShortModel: LetterShortModel) {
        val action = LetterListFragmentDirections.actionLetterListFragmentToLetterWritingFragment()
        action.letterId = letterShortModel.letterId
        findNavController().navigate(action)

    }
}