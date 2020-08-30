package com.atahar.germanschool.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.FragmentLetterWritingBinding
import com.atahar.germanschool.db.GermanSchoolDatabase
import com.atahar.germanschool.repository.LettersRepository
import com.atahar.germanschool.viewmodel.LettersViewModel
import com.atahar.germanschool.viewmodel.LettersViewModelFactory

class LetterWritingFragment : Fragment() {

    private lateinit var viewModel: LettersViewModel
    private lateinit var menu: Menu

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        val binding = DataBindingUtil.inflate<FragmentLetterWritingBinding>(
            inflater,
            R.layout.fragment_letter_writing,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val repository = LettersRepository.getInstance(
            GermanSchoolDatabase.getInstance(application).lettersDao)

        val factory = LettersViewModelFactory(
            repository,
            LetterWritingFragmentArgs.fromBundle(requireArguments()).letterId
        )

        viewModel = ViewModelProvider(this, factory).get(LettersViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getLetterById().observe(viewLifecycleOwner, Observer {

            if (it != null) {
                viewModel.letter.value = it
            }
        })

        viewModel.onTitleChange.observe(viewLifecycleOwner, Observer { hasTranslated ->
            if (hasTranslated) {
                menu.findItem(R.id.action_translate).title = "Hide"
            } else {
                menu.findItem(R.id.action_translate).title = "Translate"
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_letter_writing, menu)
        this.menu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_translate -> showTranslation()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showTranslation() {
        viewModel.actionTranslateOnClick()
    }
}