package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val email = intent.getStringExtra("email")
    }
}