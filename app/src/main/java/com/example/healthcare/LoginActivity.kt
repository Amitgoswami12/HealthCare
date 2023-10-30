package com.example.healthcare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var edUserName = findViewById<EditText>(R.id.editTextText)
        var edPassword = findViewById<EditText>(R.id.editTextText2)
        var btn = findViewById<Button>(R.id.button)
        var tv = findViewById<TextView>(R.id.textView3)



        btn.setOnClickListener(View.OnClickListener {
            val usernameText = edUserName.text.toString()
            val passwordText = edPassword.text.toString()
            val healthcare = "your_healthcare_value"
            val db = MyDatabaseHelper(this, healthcare, null,1)

            if (usernameText.length ==0 || passwordText.length ==0 ){
                Toast.makeText(applicationContext, "Please Fill All The Details",Toast.LENGTH_SHORT).show()
            }
            else {
                val username = "Amit"
                val password = "Amit@12"

                if (db.login(username , password)==1){
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    // Create or access a SharedPreferences object
                    val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)

                    // Create an editor to modify the SharedPreferences
                    val editor = sharedPreferences.edit()

                    // Put a String value with the key "username"
                    val username = "your_username"
                    editor.putString("username", username)

                    // Apply the changes to SharedPreferences
                    editor.apply()

                    tv.setOnClickListener(View.OnClickListener {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    })
                }
            }
            })
        tv.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)

        })

    }
}