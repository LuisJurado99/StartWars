package com.technical.starwars.data.entity.starwars

import com.google.gson.annotations.SerializedName

data class StarwarsPeople(@SerializedName("image")
                          val image: String? = "",
                          @SerializedName("homeworld")
                          val homeworld: String = "",
                          @SerializedName("gender")
                          val gender: String = "",
                          @SerializedName("cybernetics")
                          val cybernetics: String = "",
                          @SerializedName("skinColor")
                          val skinColor: String = "",
                          @SerializedName("mass")
                          val mass: Int = 0,
                          @SerializedName("wiki")
                          val wiki: String = "",
                          @SerializedName("born")
                          val born: Int = 0,
                          @SerializedName("diedLocation")
                          val diedLocation: String = "",
                          @SerializedName("died")
                          val _died: Int = 0,
                          @SerializedName("bornLocation")
                          val bornLocation: String = "",
                          @SerializedName("eyeColor")
                          val eyeColor: String = "",
                          @SerializedName("species")
                          val species: String = "",
                          @SerializedName("name")
                          val name: String = "",
                          @SerializedName("id")
                          val id: Int = 0,
                          @SerializedName("hairColor")
                          val hairColor: String = "",
                          @SerializedName("height")
                          val _height: Double = 0.0) {
    val height: String get() = _height.toString()
    val died: String get() = _died.toString()
}