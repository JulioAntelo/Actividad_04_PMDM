package com.example.actividad_04_pmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_imc2 : AppCompatActivity() {
    var message = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc2)

        val result = intent.getFloatExtra("resultado",0F)
        val resultText = findViewById<TextView>(R.id.resultView)
        val volver = findViewById<Button>(R.id.resultReturn)

        volver.setOnClickListener {
            newActivity()
        }
        imageForImc(result)
        resultText.text = "IMC: ${result.toString().substring(0,5)} \n$message"


    }


    fun imageForImc(imc : Float){
        val image = findViewById<ImageView>(R.id.resultImage)
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
        val intent = Intent(applicationContext,Activity_imc::class.java)
        startActivity(intent)
    }
}

