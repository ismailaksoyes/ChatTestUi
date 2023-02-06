package com.example.chattest.common.extensions

fun String.toCountFormat(){
    try {
        val count = this.toIntOrNull()?:0
        if (count in 1000..999999){
            "${(count) / 1000}K"
        }else if(count in 1000000..999999999) {
            "${(count) / 1000000}MN"
        }else if(count > 1000000000) {
            "${(count) / 1000000000}MR"
        } else {
            count.toString()
        }
    }catch (e:Exception){

    }


}