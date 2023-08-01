package com.technical.starwars.data.entity

import com.google.gson.annotations.SerializedName

data class StarWars(@SerializedName("image")
                    val image: String? = "",
                    @SerializedName("name")
                    val name: String? = "")