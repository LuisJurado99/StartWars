package com.technical.starwars.ui.personajeslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technical.starwars.databinding.ItemPeopleBinding
import com.technical.starwars.domain.data.People

class CharacterAdapter(private val listCharacter: List<People>): RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val bindingReturn = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false) 
        return CharacterViewHolder(bindingReturn)
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacter[position])
    }
}