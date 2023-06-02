package com.example.tax_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {
    private lateinit var oth_inc: EditText
    private lateinit var exe_all: EditText
    private lateinit var home_loan_int: EditText
    private lateinit var home_loan: EditText
    private lateinit var next_step: Button
    private lateinit var button: Button
    private lateinit var answer: EditText

    var inc_sal: Double = 0.0
    var int_inc: Double = 0.0
    var rent_inc: Double = 0.0
    var dig_inc: Double = 0.0
    var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        oth_inc = findViewById(R.id.oth_inc_input)
        exe_all = findViewById(R.id.exe_all_input)
        home_loan = findViewById(R.id.home_loan_input)
        home_loan_int = findViewById(R.id.home_loan_int_input)
        next_step = findViewById(R.id.next_step)
        button = findViewById(R.id.button)
        answer = findViewById(R.id.answer)

        val bundle = intent.extras


        if(bundle != null)
        {
            inc_sal = bundle.getDouble("inc_sal")
            int_inc = bundle.getDouble("int_inc")
            rent_inc = bundle.getDouble("rent_inc")
            dig_inc = bundle.getDouble("dig_inc")
        }

        next_step.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            result = calculate();
            answer.setText(result.toString())
        }


    }

    private fun calculate(): Double {
        val total = inc_sal + int_inc + rent_inc + dig_inc
        var slab1: Double = 0.0
        var slab2: Double = 0.0
        var slab3: Double = 0.0
        var slab4: Double = 0.0
        var final_slab: Double = 0.0

        if(total>500000)
        {
            slab1 = ((500000 - 250000)*5/100).toDouble()
        }
        else
        {
            slab1 = ((total - 250000)*5/100)
        }

        if(total>750000)
        {
            slab2 = ((750000 - 500000)*10/100).toDouble()
        }
        else
        {
            slab2 = (total - 500000)*10/100
        }

        if(total>1000000)
        {
            slab3 = ((1000000 - 750000)*15/100).toDouble()
        }
        else
        {
            slab3 = (total - 750000)*15/100
        }

        if(total>1250000)
        {
            slab3 = ((1250000 - 1000000)*20/100).toDouble()
        }
        else
        {
            slab3 = (total - 1000000)*20/100
        }

        if(total>1500000)
        {
            slab4 = ((1500000 - 1250000)*25/100).toDouble()
        }
        else
        {
            slab4 = (total - 1250000)*25/100
        }

        if(total>1500000)
        {
            final_slab = ((total - 1500000)*30/100)
        }
        else
        {
            final_slab = 0.0
        }

        val result: Double = slab1 + slab2 + final_slab

        Log.i("Total: ", total.toString())
        Log.i("Slab 1: ", slab1.toString())
        Log.i("Slab 2: ", slab2.toString())
        Log.i("Slab 3: ", slab3.toString())
        Log.i("Slab 4: ", slab4.toString())
        Log.i("final slab: ", final_slab.toString())
        Log.i("Result: ", result.toString())
        return result
    }


}


