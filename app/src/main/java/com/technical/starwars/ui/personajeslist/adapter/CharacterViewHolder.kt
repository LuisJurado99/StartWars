package com.technical.starwars.ui.personajeslist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technical.starwars.R
import com.technical.starwars.data.entity.RickMorty
import com.technical.starwars.databinding.ItemPeopleBinding

class CharacterViewHolder(private val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(people: RickMorty) {
        binding.people = people
    }
}