package com.ainsigne.utilities

import android.widget.ImageView
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.toRoundImage(
    url: String?,
    @DrawableRes placeholder: Int = R.drawable.image_profile_empty,
    @DrawableRes error: Int = R.drawable.image_profile_empty,
) {
    val requestOptions = RequestOptions()
        .circleCrop()
        .placeholder(ContextCompat.getDrawable(this.context, placeholder))
        .error(ContextCompat.getDrawable(this.context, error))

    Glide.with(this.context)
        .load(url)
        .apply(requestOptions)
        .into(this)
}

fun ImageView.loadUrl(
    @DrawableRes drawable: Int? = R.drawable.image_profile_empty,
    url: String? = null,
    @DrawableRes placeholder: Int = R.drawable.image_profile_empty,
    @DrawableRes error: Int = R.drawable.image_profile_empty,
    @DimenRes radius: Int? = null
) {
    val requestOptions = RequestOptions()
        .placeholder(ContextCompat.getDrawable(this.context, placeholder))
        .error(ContextCompat.getDrawable(this.context, error))
    radius?.let {
        requestOptions.apply(
            RequestOptions.bitmapTransform(
                RoundedCorners(
                    this.context.resources.getDimension(radius).toInt()
                )
            )
        )
    }
    url?.let {
        Glide.with(this.context)
            .load(url)
            .apply(requestOptions)
            .into(this)
    } ?: run {
        Glide.with(this.context)
            .load(drawable)
            .apply(requestOptions)
            .into(this)
    }

}
