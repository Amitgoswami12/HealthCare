package com.example.healthcare

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class LoginActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var edUserName = findViewById<EditText>(R.id.editTextText)
        var edPassword = findViewById<EditText>(R.id.editTextText2)
        var btn = findViewById<Button>(R.id.button)
        var tv = findViewById<TextView>(R.id.textView3)



        btn.setOnClickListener {
            val usernameText = edUserName.text.toString()
            val passwordText = edPassword.text.toString()
            val db = MyDatabaseHelper(this)

            if (usernameText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please Fill All The Details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val userData = db.getUserData() // Retrieve user data from the database
                if (userData != null) {

                    if (userData != null && userData.username == usernameText && userData.password == passwordText) {

                        Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT)
                            .show()
                        // Create or access a SharedPreferences object
                        val sharedPreferences =
                            getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)

                        // Create an editor to modify the SharedPreferences
                        val editor = sharedPreferences.edit()

                        // Put a String value with the key "username"
                        editor.putString("username", usernameText)

                        // Apply the changes to SharedPreferences
                        editor.apply()

                        tv.setOnClickListener {
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Invalid username or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            tv.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
