package com.technical.starwars.ui.personajeslist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.technical.starwars.databinding.ItemPeopleBinding
import com.technical.starwars.domain.data.People

class CharacterViewHolder(private val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(people: People, onClickCharacter: CharacterAdapter.OnClickCharacter) {
        binding.people = people
        binding.root.setOnClickListener {
            onClickCharacter.clickShowDetails(people)
        }
    }
}