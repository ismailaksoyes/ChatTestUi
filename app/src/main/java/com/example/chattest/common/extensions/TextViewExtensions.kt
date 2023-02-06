package com.example.chattest.common.extensions

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.chattest.R
import com.example.chattest.shared.utils.TextColorType


fun TextView.textChangeColor(type:TextColorType) {
    try {
        val controlTag = this.tag.toString()

        when(type){
            TextColorType.BLACK ->{
                if (controlTag == "1"){
                    this.tag = "0"
                    val from = ContextCompat.getColor(this.context, R.color.white);
                    val  to = ContextCompat.getColor(this.context,R.color.black);
                    val anim = ValueAnimator()
                    anim.setIntValues(from, to)
                    anim.setEvaluator(ArgbEvaluator())
                    anim.addUpdateListener {  itValue->
                        setTextColor(itValue.animatedValue as Int)
                    }

                    anim.setDuration(1000)
                    anim.start()
                }

            }
            TextColorType.WHITE ->{
                if (controlTag == "0"){
                    this.tag = "1"
                    val from = ContextCompat.getColor(this.context, R.color.black);
                    val  to = ContextCompat.getColor(this.context,R.color.white);
                    val anim = ValueAnimator()
                    anim.setIntValues(from, to)
                    anim.setEvaluator(ArgbEvaluator())
                    anim.addUpdateListener {  itValue->
                        setTextColor(itValue.animatedValue as Int)
                    }
                    anim.setDuration(1000)
                    anim.start()
                }
            }
        }
    }catch (e:Exception){

    }

}