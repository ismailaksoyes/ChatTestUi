plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    compileSdk = Config.compileSdkVersion
    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(Libs.AndroidX.androidx_appcompat)
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.core_ktx)
    implementation(Libs.AndroidX.constraint_layout)
    implementation(Libs.AndroidX.navigation_fragment)
    implementation(Libs.AndroidX.navigation_ui_ktx)
    implementation(Libs.AndroidX.live_data_ktx)
    implementation(Libs.AndroidX.live_data_vm)
    implementation(Libs.AndroidX.pagingX)
    implementation(Libs.AndroidX.legacy_support)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.material)

    // Hilt for Dependency Injection
    implementation(Libs.DaggerHilt.daggerHilt)
    kapt(Libs.DaggerHilt.daggerHiltCompiler)

    // Image
    implementation(Libs.Glide.glide)
    kapt(Libs.Glide.compiler)
    implementation(Libs.Indicator.dotsIndicator)

    // Coroutines
    implementation(Libs.Coroutines.android)
    implementation(Libs.Coroutines.core)

    // Lifecycle
    implementation(Libs.LifeCycle.common)
    implementation(Libs.LifeCycle.runtime)


    // Network
    implementation(Libs.Network.gson)
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.converter)
    implementation(Libs.Network.okhttp)
    implementation(Libs.Network.interceptor)
    implementation(Libs.Logger.logcat)



}