package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Weigth
    lateinit var removeWeightButton: Button
    lateinit var addWeightButton: Button
    lateinit var weightTextView: TextView

    //Heigth
    lateinit var heightSlider: Slider
    lateinit var heightTextView: TextView

    //Result
    lateinit var  calculateButton: Button
    lateinit var resultTextView: TextView

    var weigth = 74.0f
    var heigth = 170.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // busco los componentes en la vista y los guardo en sus respectivas variables
        //weigth
        removeWeightButton = findViewById(R.id.removeWeightButton )
        addWeightButton = findViewById(R.id.addWeightButton)
        weightTextView = findViewById(R.id.weightTextView)
        //heigth
        heightSlider = findViewById(R.id.heightSlider)
        heightTextView = findViewById(R.id.heightTextView)
        //result
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)


        removeWeightButton.setOnClickListener {
            weigth --
            weightTextView.text = "${weigth.toInt()} kg"
        }
        addWeightButton.setOnClickListener {
            weigth ++
            weightTextView.text = "${weigth.toInt()} kg"
        }

        heightSlider.addOnChangeListener { slider, value, fromUser ->
            heigth = value
            heightTextView.text = "${value.toInt()} cm"
        }

        calculateButton.setOnClickListener {
            val result = weigth / (heigth / 100).pow(2)

            resultTextView.text = String.format("%.2f" , result)

            var colorId = 0
            var descriptionId = ""
            when (result) {
                in 0f ..<18.5f -> {
                colorId = getColor(R.color.bmi_underweight)
                descriptionId = getString(R.string.bmi_underweight)
            }
                in 18.5f..< 25f -> {colorId = getColor(R.color.bmi_normalweight)
                descriptionId = getString(bmi_underweight)
            }
                in 25f..<30f -> {colorId = getColor(R.color.bmi_overweight)
                descriptionId = getString(bmi_overweight)

            }
                in 30f..<35f -> {
                colorId = getColor(R.color.obecity)
                descriptionId = getString(obecity)

            }
                else -> {
                    colorId = getColor(R.color.extreme_obecity)
                    descriptionId = getString(extreme_obecity)
            }

            }
            descriptionTextView.text = getString(descriptionId)
            descriptionTextView.setTextColor(getColor(colorId))
            resultTextView.setTextColor(colorId)
        }
    }

}