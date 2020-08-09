package com.atahar.germanschool.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.atahar.germanschool.db.entity.LetterShortModel
import com.atahar.germanschool.R
import com.atahar.germanschool.databinding.ItemLetterListBinding
import com.atahar.germanschool.listener.LetterListClickListener

class LetterListAdapter(private val letterListClickListener: LetterListClickListener) :
    RecyclerView.Adapter<LetterListAdapter.LetterListViewHolder>() {


    var data = listOf<LetterShortModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterListViewHolder {
        return LetterListViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: LetterListViewHolder, position: Int) {
        holder.binding.item = data[position]
        holder.binding.itemLetterListRoot.setOnClickListener{
            letterListClickListener.onItemClick(data[position])
        }

    }

    class LetterListViewHolder private constructor(val binding: ItemLetterListBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): LetterListViewHolder {

                val binding =  DataBindingUtil.inflate<ItemLetterListBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_letter_list,
                    parent,
                    false
                )

                return LetterListViewHolder(binding)
            }
        }
    }

}