package com.atahar.germanschool.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atahar.germanschool.db.DeutscheWritingDatabase
import com.atahar.germanschool.repository.LettersRepository
import com.atahar.germanschool.viewmodel.LettersViewModel
import com.atahar.germanschool.viewmodel.LettersViewModelFactory
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.FragmentLetterWritingBinding

class LetterWritingFragment : Fragment() {

    private lateinit var viewModel: LettersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLetterWritingBinding>(
            inflater,
            R.layout.fragment_letter_writing,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val repository = LettersRepository.getInstance(
            DeutscheWritingDatabase.getInstance(application).lettersDao)

        val factory = LettersViewModelFactory(repository, 2)
        viewModel = ViewModelProvider(this, factory).get(LettersViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.getLetters().observe(viewLifecycleOwner, Observer {

            if (it != null && it.isNotEmpty()) {
                it.size
                viewModel.letter.value = it.last()
            }
        })

        return binding.root
    }
}