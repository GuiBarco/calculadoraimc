package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnCalculate: Button = findViewById(R.id.btncalculate)
        val edtPeso : EditText = findViewById(R.id.edttext_peso)
        val edtAltura : EditText = findViewById(R.id.edttext_altura)


        btnCalculate.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val alt: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val altfinal: Float = alt * alt
                val result = peso / altfinal

                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULT", result)

                    }

                startActivity(intent)

            }else{
                Toast.makeText(this, "Preencher todo os campos", Toast.LENGTH_LONG).show()
            }

        }
    }
}