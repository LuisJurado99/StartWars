package com.technical.starwars.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseRickMorty(@SerializedName("results")
                             val results: List<RickMorty>?)