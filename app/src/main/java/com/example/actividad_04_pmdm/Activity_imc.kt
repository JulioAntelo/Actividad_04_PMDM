package com.example.actividad_04_pmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider


class Activity_imc : AppCompatActivity() {
    val buttonIdList = listOf(R.id.edadMinus,R.id.edadPlus,R.id.pesoMinus,R.id.pesoPlus)
    var peso = 0
    var edad = 0
    var altura = 0F

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        for (button in buttonIdList){
            val floatingbutton = findViewById<FloatingActionButton>(button)
            floatingbutton.setOnClickListener { buttons(floatingbutton) }
        }



        altura = slider()


    }

    fun slider(): Float {
        val heightTextView = findViewById<TextView>(R.id.sliderTextView)
        val slider = findViewById<RangeSlider>(R.id.slider)
        var altura = 0F
        slider.valueTo = 220F
        slider.valueFrom = 120.0F
        slider.values = listOf(120F)

        slider.addOnChangeListener{_,value,_->
            heightTextView.text = "${value.toInt()} cm"
            altura = value
        }
        return altura
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
}