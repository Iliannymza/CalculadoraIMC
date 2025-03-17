package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.log
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Declaramos las variables

        lateinit var weightEditText: EditText
        lateinit var heigtEditText: EditText
        lateinit var calculateButton: Button



        lateinit var resultadoTextView: TextView



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Le pedimos que la busque en el activity main

        weightEditText = findViewById(R.id.weightEditText )
        heigtEditText = findViewById(R.id.heigtEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)


        calculateButton.setOnClickListener {

            val peso = weightEditText.text.toString().toFloat()
            val altura = heigtEditText.text.toString().toFloat()


            // formula para calcular imc 
           val resultado =  peso / (altura / 100).pow(2)

            resultadoTextView.text = String.format("%.2f", resultado)


        }

    }

}