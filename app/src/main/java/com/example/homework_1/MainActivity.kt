package com.example.homework_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.capitalize

class MainActivity : AppCompatActivity() {

    var name : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val email = intent.getStringExtra("email")

        name = findViewById(R.id.nameTextView)
        name!!.text = parseNameSurname(email!!)
    }

    private fun parseNameSurname(email : String) : String {
        var name : String = ""
        var surname : String = ""
        var changer : Boolean = false

        for(ch in email) {
            if(ch == '@') {
                break
            }
            if(ch == '.') {
                changer = true
                continue
            }
            if(!changer) {
                name += ch
            }
            else {
                surname += ch
            }
        }
        if(surname == "" ) {
            return name
        }
        return "${name.capitalize()} ${surname.capitalize()}"
    }
}