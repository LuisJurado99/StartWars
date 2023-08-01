package com.technical.starwars.data.entity.starwars

import com.google.gson.annotations.SerializedName

data class StarWars(@SerializedName("image")
                    val image: String? = "",
                    @SerializedName("name")
                    val name: String? = "",
                    @SerializedName("id")
                    val id: Int = 0)