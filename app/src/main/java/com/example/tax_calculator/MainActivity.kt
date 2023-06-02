package com.example.tax_calculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var next_step: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_step = findViewById(R.id.next_step)
        next_step.setOnClickListener {




            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}