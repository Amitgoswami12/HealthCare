package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class FindDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_doctor)
        var exit = findViewById<CardView>(R.id.cardBack)
        exit.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })

        var familyphysician = findViewById<CardView>(R.id.cardFDFamilyPhysician)
        familyphysician.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Family Physicians")
            startActivity(intent)
        })
        var dietician = findViewById<CardView>(R.id.cardFDDietician)
        familyphysician.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Dietician")
            startActivity(intent)
        })

        var dentist = findViewById<CardView>(R.id.cardFDDentist)
        familyphysician.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Dentist")
            startActivity(intent)
        })
        var surgeon = findViewById<CardView>(R.id.cardFDSurgeon)
        familyphysician.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Surgeon")
            startActivity(intent)
        })

        var cardiologist = findViewById<CardView>(R.id.cardFDCardiologists)
        familyphysician.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Cardiologist")
            startActivity(intent)
        })
    }
}