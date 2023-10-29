package com.example.actividad_04_pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider


class Activity_imc : AppCompatActivity() {
    val buttonIdList = listOf(R.id.edadMinus,R.id.edadPlus,R.id.pesoMinus,R.id.pesoPlus)
    var peso = 60
    var edad = 0
    var altura = 120F
    var resultado = 0F

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        val buttonCalc = findViewById<Button>(R.id.calcular)
        val heightTextView = findViewById<TextView>(R.id.sliderTextView)
        val slider = findViewById<RangeSlider>(R.id.slider)

        slider.valueTo = 220F
        slider.valueFrom = 120.0F
        slider.values = listOf(120F)

        for (button in buttonIdList){
            val floatingbutton = findViewById<FloatingActionButton>(button)
            floatingbutton.setOnClickListener { buttons(floatingbutton) }
        }

        slider.addOnChangeListener{_,value,_->
            heightTextView.text = "${value.toInt()} cm"
            altura = value
        }

        buttonCalc.setOnClickListener {
            resultado = peso/((altura/100)*(altura/100))
            newActivity()
        }

    }



   fun buttons(button: FloatingActionButton){
       val edadTextView = findViewById<TextView>(R.id.edadTextView)
       val pesoTextView = findViewById<TextView>(R.id.pesoTextView )
       when(button.id){
           R.id.edadMinus ->{
                edad = edadTextView.text.toString().toInt()
                edadTextView.text = if(edad > 1){
                    (edad-1).toString()
                }else{
                    edad.toString()
                }
            }
           R.id.edadPlus->{
               edad = edadTextView.text.toString().toInt()
               edadTextView.text = (edad+1).toString()
           }
           R.id.pesoMinus ->{
               peso = pesoTextView.text.toString().toInt()
               pesoTextView.text = if(peso > 1){
                   (peso-1).toString()
               }else{
                   peso.toString()
               }
           }
           R.id.pesoPlus->{
               peso = pesoTextView.text.toString().toInt()
               pesoTextView.text = (peso+1).toString()
           }
       }
   }

    fun newActivity(){
        val intent = Intent(applicationContext,Activity_imc2::class.java)
        intent.putExtra("resultado",resultado)
        startActivity(intent)
    }
}