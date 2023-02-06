package com.example.chattest.common.extensions

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.*
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.chattest.R


fun ImageView.changeColorBlackToBlue() {
    try {
        val controlTag = this.tag.toString()
        if (controlTag == "0"){
            this.tag = "1"
            val from = ContextCompat.getColor(this.context, R.color.black);
            val  to = ContextCompat.getColor(this.context, R.color.light_blue);
            val anim = ValueAnimator()
            anim.setIntValues(from, to)
            anim.setEvaluator(ArgbEvaluator())
            anim.addUpdateListener {  itValue->
                val nextIconWrap = DrawableCompat.wrap(this.drawable)
                DrawableCompat.setTint(nextIconWrap, itValue.animatedValue as Int)
            }

            anim.setDuration(1000)
            anim.start()
        }

    }catch (e:Exception){

    }

}

fun ImageView.changeColorBlueToBlack() {
    try {
        val controlTag = this.tag.toString()
        if (controlTag == "1"){
            this.tag = "0"
            val from = ContextCompat.getColor(this.context, R.color.light_blue);
            val  to = ContextCompat.getColor(this.context,R.color.black);
            val anim = ValueAnimator()
            anim.setIntValues(from, to)
            anim.setEvaluator(ArgbEvaluator())
            anim.addUpdateListener {  itValue->
                val nextIconWrap = DrawableCompat.wrap(this.drawable)
                DrawableCompat.setTint(nextIconWrap, itValue.animatedValue as Int)
            }

            anim.setDuration(1000)
            anim.start()
        }

    }catch (e:Exception){

    }

}

fun ImageView.changeColorWhiteToBlack() {
    try {
        val controlTag = this.tag.toString()
        if (controlTag == "0"){
            this.tag = "1"
            val from = ContextCompat.getColor(this.context, R.color.white);
            val  to = ContextCompat.getColor(this.context,R.color.black);
            val anim = ValueAnimator()
            anim.setIntValues(from, to)
            anim.setEvaluator(ArgbEvaluator())
            anim.addUpdateListener {  itValue->
                val nextIconWrap = DrawableCompat.wrap(this.drawable)
                DrawableCompat.setTint(nextIconWrap, itValue.animatedValue as Int)
            }

            anim.setDuration(1000)
            anim.start()
        }

    }catch (e:Exception){

    }

}

fun ImageView.changeColorBlackToWhite() {
    try {
        val controlTag = this.tag.toString()
        if (controlTag == "1"){
            this.tag = "0"
            val from = ContextCompat.getColor(this.context, R.color.black);
            val  to = ContextCompat.getColor(this.context,R.color.white);
            val anim = ValueAnimator()
            anim.setIntValues(from, to)
            anim.setEvaluator(ArgbEvaluator())
            anim.addUpdateListener {  itValue->
                val nextIconWrap = DrawableCompat.wrap(this.drawable)
                DrawableCompat.setTint(nextIconWrap, itValue.animatedValue as Int)
            }

            anim.setDuration(1000)
            anim.start()
        }

    }catch (e:Exception){

    }

}

fun ImageView.loadUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

fun ImageView.loadUrlCircle(url: String?){
    Glide.with(context)
        .load(url)
        .circleCrop()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

fun <T> ImageView.loadCircularImage(
    model: T,
    borderSize: Float = 0F,
    borderColor: Int = Color.WHITE
) {
    Glide.with(context)
        .asBitmap()
        .load(model)
        .apply(RequestOptions.circleCropTransform())
        .into(object : BitmapImageViewTarget(this) {
            override fun setResource(resource: Bitmap?) {
                setImageDrawable(
                    resource?.run {
                        RoundedBitmapDrawableFactory.create(
                            resources,
                            if (borderSize > 0) {
                                createBitmapWithBorder(borderSize, borderColor)
                            } else {
                                this
                            }
                        ).apply {
                            isCircular = true
                        }
                    }
                )
            }
        })
}

private fun Bitmap.createBitmapWithBorder(borderSize: Float, borderColor: Int): Bitmap {
    val borderOffset = (borderSize * 2).toInt()
    val halfWidth = width / 2
    val halfHeight = height / 2
    val circleRadius = Math.min(halfWidth, halfHeight).toFloat()
    val newBitmap = Bitmap.createBitmap(
        width + borderOffset,
        height + borderOffset,
        Bitmap.Config.ARGB_8888
    )

    // Center coordinates of the image
    val centerX = halfWidth + borderSize
    val centerY = halfHeight + borderSize

    val paint = Paint()
    val canvas = Canvas(newBitmap).apply {
        // Set transparent initial area
        drawARGB(0, 0, 0, 0)
    }

    // Draw the transparent initial area
    paint.isAntiAlias = true
    paint.style = Paint.Style.FILL
    canvas.drawCircle(centerX, centerY, circleRadius, paint)

    // Draw the image
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    canvas.drawBitmap(this, borderSize, borderSize, paint)

    // Draw the createBitmapWithBorder
    paint.xfermode = null
    paint.style = Paint.Style.STROKE
    paint.color = borderColor
    paint.strokeWidth = borderSize
    canvas.drawCircle(centerX, centerY, circleRadius, paint)
    return newBitmap
}
