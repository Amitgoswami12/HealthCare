package com.example.healthcare

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)

        // Create an editor to modify the SharedPreferences
        val editor = sharedPreferences.edit()

        // Put a String value with the key "username"
        val username = "your_username"
        editor.putString("username", username)

        // Apply the changes to SharedPreferences
        editor.apply()
        Toast.makeText(applicationContext, "Welcome", Toast.LENGTH_SHORT).show()

        var exit = findViewById<CardView>(R.id.cardExist)
        exit.setOnClickListener(View.OnClickListener {
            val sharedpreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
            val editor = sharedpreferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        })
        var findDoctor = findViewById<CardView>(R.id.cardFindDoctor)
        findDoctor.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FindDoctorActivity::class.java)
            startActivity(intent)
        })
    }
}