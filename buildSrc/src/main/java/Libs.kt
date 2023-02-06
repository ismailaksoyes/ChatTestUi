object Libs {

    object AndroidX {
        const val activity = "androidx.activity:activity-ktx:" + Versions.appCompat
        const val android_tools = "com.android.tools.build:gradle:" + Versions.tools
        const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:" + Versions.kotlinGradlePlugin
        const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:" + Versions.kotlinSerialization
        const val fragmentKtx = "androidx.fragment:fragment-ktx:"+Versions.appCompat
        const val androidx_appcompat =
            "androidx.appcompat:appcompat:" + Versions.appCompat
        const val core_ktx= "androidx.core:core-ktx:" + Versions.coreKtx
        const val constraint_layout =
            "androidx.constraintlayout:constraintlayout:" + Versions.constraint
        const val navigation_fragment =
            "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation

        const val material = "com.google.android.material:material:"+Versions.material

        const val nav_args_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
        const val navigation_ui_ktx =
            "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val legacy_support =
            "androidx.legacy:legacy-support-v4:" + Versions.legacy_support
        const val live_data_vm =
            "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.livedata
        const val live_data_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.livedata

        const val pagingX =
            "androidx.paging:paging-runtime-ktx:" + Versions.paging
        const val recyclerview = "androidx.recyclerview:recyclerview:" + Versions.recyclerview


    }

    object Coroutines {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object DaggerHilt {
        const val daggerHilt = "com.google.dagger:hilt-android:" + Versions.hilt
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:" + Versions.hilt
        const val daggerHiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:" + Versions.glide
        const val compiler = "com.github.bumptech.glide:compiler:" + Versions.glide
    }

    object Indicator{
        const val dotsIndicator = "com.tbuonomo:dotsindicator:"+ Versions.indicator
    }

    object LifeCycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle
        const val common = "androidx.lifecycle:lifecycle-common-java8:" + Versions.lifecycle
    }


    object Network {
        const val gson: String = "com.google.code.gson:gson:" + Versions.gson
        const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
        const val converter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
        const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http
    }

    object Logger {
        const val logcat = "com.squareup.logcat:logcat:" + Versions.logcat
    }


}