package com.example.tax_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var next_step: Button
    private lateinit var inc_sal: EditText
    private lateinit var int_inc: EditText
    private lateinit var rent_inc: EditText
    private lateinit var dig_inc: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        inc_sal = findViewById(R.id.inc_sal_input)
        int_inc = findViewById(R.id.int_inc_input)
        rent_inc = findViewById(R.id.rent_inc_input)
        dig_inc = findViewById(R.id.dig_inc_input)
        next_step = findViewById(R.id.next_step)
        next_step.setOnClickListener {

            val bundle = Bundle()
            bundle.putDouble("inc_sal", inc_sal.text.toString().toDouble())
            bundle.putDouble("int_inc", int_inc.text.toString().toDouble())
            bundle.putDouble("rent_inc", rent_inc.text.toString().toDouble())
            bundle.putDouble("dig_inc", dig_inc.text.toString().toDouble())

            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}