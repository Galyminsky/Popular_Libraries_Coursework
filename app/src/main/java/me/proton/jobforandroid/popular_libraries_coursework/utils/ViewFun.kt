package me.proton.jobforandroid.popular_libraries_coursework.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import me.proton.jobforandroid.popular_libraries_coursework.R

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}
fun ImageView.loadGlide(url: String?) {
    Glide.with(context).load(url).transform(CircleCrop())
        .placeholder(R.drawable.ic_user_placeholder).into(this)
}