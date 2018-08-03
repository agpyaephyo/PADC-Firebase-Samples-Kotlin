package com.padcmyanmar.firebase.kotlin

import android.app.Application

class FirebaseKotlinApp : Application() {
    companion object {
        val TAG = "Firebase-Samples-Kotlin"
    }

    override fun onCreate() {
        super.onCreate()
    }
}
