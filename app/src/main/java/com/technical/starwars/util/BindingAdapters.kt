package com.technical.starwars.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.technical.starwars.R

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl (view: ImageView, url: String?) {
            Picasso.get().load(url).error(R.drawable.placeholder).into(view)
        }
    }
}