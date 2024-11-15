package com.example.homework_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class AuthActivity : AppCompatActivity() {

    private var editTextEmail : EditText? = null
    private var editTextPassword : EditText? = null
    private lateinit var buttonRegister : Button

    private var isAllFieldsCorrect = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        editTextEmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)

        buttonRegister = findViewById(R.id.buttonRegister)

        buttonRegister.setOnClickListener {
            isAllFieldsCorrect = checkAllFields()

            if (isAllFieldsCorrect) {
                val intent = Intent(this@AuthActivity, MainActivity::class.java)
                intent.putExtra("email", editTextEmail!!.text.toString())
                startActivity(intent)
            }
        }

    }

    private fun checkAllFields(): Boolean {
        //Regex for email.
        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

        //Regex for password. Minimum eight characters, at least one letter and one number
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")

        if(editTextEmail!!.length() == 0) {
            editTextEmail!!.error = "This field is required"
            return false
        }
        if(!emailRegex.matches(editTextEmail!!.text.toString())) {
            editTextEmail!!.error = "Incorrect email"
            return false
        }
        if(editTextPassword!!.length() == 0) {
            editTextPassword!!.error = "This field is required"
            return false
        }
        if(!passwordRegex.matches(editTextPassword!!.text.toString())) {
            editTextPassword!!.error = "Password could contains at least:\n\t8 characters" +
                    "\n\tone letter and one number"
            return false
        }
        return true
    }
}