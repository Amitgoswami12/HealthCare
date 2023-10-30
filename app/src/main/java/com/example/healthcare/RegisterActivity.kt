package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.contentValuesOf

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var edUserName = findViewById<EditText>(R.id.editTextUsername)
        var edemail = findViewById<EditText>(R.id.editTextEmail)
        var edPassword = findViewById<EditText>(R.id.editTextRegpassword)
        var edcnPassword = findViewById<EditText>(R.id.editTextConPassword)
        var login = findViewById<TextView>(R.id.textView3)
        val db = MyDatabaseHelper(this)
        var btn1 = findViewById<Button>(R.id.Regbutton)

        btn1.setOnClickListener(View.OnClickListener {
            val usernameText = edUserName.text.toString()
            val emailText = edUserName.text.toString()
            val passwordText = edPassword.text.toString()
            val conpasswordText = edcnPassword.text.toString()

            if (usernameText.length == 0 || passwordText.length == 0 || emailText.length == 0||conpasswordText.length ==0) {
                Toast.makeText(
                    applicationContext,
                    "Please Fill All The Details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (passwordText==conpasswordText){



                    db.writableDatabase.use {
                        val username = "user123"
                        val email = "user123@example.com"
                        val password = "password123"

                        val values = contentValuesOf(
                            "username" to username,
                            "email" to email,
                            "password" to password


                        )
                        Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_SHORT)
                            .show()
                    }
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext, "Password doesn't match", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

        login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
    }


}

