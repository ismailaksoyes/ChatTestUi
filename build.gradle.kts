// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://www.jitpack.io")
    }
    dependencies {
        classpath(Libs.AndroidX.android_tools)
        classpath(Libs.AndroidX.kotlin_gradle_plugin)
        classpath(Libs.AndroidX.kotlin_serialization)
        classpath(Libs.DaggerHilt.daggerHiltGradlePlugin)
        classpath(Libs.AndroidX.nav_args_plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}