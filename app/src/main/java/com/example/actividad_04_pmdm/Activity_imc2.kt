package com.example.actividad_04_pmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @property message A string the contains the message to be displayed based on the result of the Imc.
 */
class Activity_imc2 : AppCompatActivity() {
    var message = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc2)

        //Recives the result of the Imc from Activity_imc
        val result = intent.getFloatExtra("resultado",0F)
        //Initializes the textView and button
        val resultText = findViewById<TextView>(R.id.resultView)
        val volver = findViewById<Button>(R.id.resultReturn)

        //Uses the function to return to the previous activity
        volver.setOnClickListener {
            newActivity()
        }
        imageForImc(result)
        resultText.text = "IMC: ${result.toString().substring(0,5)} \n$message"


    }

    /**
     * Displays an image based on the number passed as a parameter.
     * @param imc The result of the Imc as a Float.
     */
    fun imageForImc(imc : Float){
        //Initializes the imageView
        val image = findViewById<ImageView>(R.id.resultImage)

        //displayes an image and text based on the Imc
        if (imc < 18.5){
            image.setImageResource(R.drawable.skeleton)
            message = "Tu peso esta debajo de lo normal"
        }else if (imc >= 18.5 && imc < 25){
            image.setImageResource(R.drawable.gigachad)
            message = "Tu peso esta perfecto"
        }else if (imc >= 25 && imc < 30){
            image.setImageResource(R.drawable.mamoa)
            message = "Tu peso esta un poco mas lo normal"
        }else{
            image.setImageResource(R.drawable.fat)
            message = "Tu peso esta mas de lo normal"
        }
    }

    fun newActivity(){
        onBackPressed()
    }
}

