package com.example.actividad_04_pmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

/**
 * @property buttonIdList Is a list of all the flatingActionButton Id´s.
 * @property peso Contains the weight.
 * @property edad Contains the age.
 * @property altura Contains the height.
 * @property resultado Contains the result of the Imc calculation.
 */
class Activity_imc : AppCompatActivity() {
    val buttonIdList = listOf(R.id.edadMinus,R.id.edadPlus,R.id.pesoMinus,R.id.pesoPlus)
    var peso = 60
    var edad = 0
    var altura = 120F
    var resultado = 0F

    //FUNCION QUE FINALIZA LA ACTIVIDAD


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        //Initializes the different buttons
        val buttonCalc = findViewById<Button>(R.id.calcular)
        val heightTextView = findViewById<TextView>(R.id.sliderTextView)
        val slider = findViewById<RangeSlider>(R.id.slider)
        val btnvolver:Button=findViewById(R.id.volverdeimc)

        //Sets the values for the RangeSlider
        slider.valueTo = 220F
        slider.valueFrom = 120.0F
        slider.values = listOf(120F)

        //Loop the iterates over all the floatingActionButton id´s and initializes them
        for (button in buttonIdList){
            val floatingbutton = findViewById<FloatingActionButton>(button)
            //Uses the function buttons to check what to do depending on what button is pressed
            floatingbutton.setOnClickListener { buttons(floatingbutton) }
        }

        //Saves the value of the slider in  altura
        slider.addOnChangeListener{_,value,_->
            heightTextView.text = "${value.toInt()} cm"
            altura = value
        }

        //Calculates de Imc once the button is pressed.
        buttonCalc.setOnClickListener {
            resultado = peso/((altura/100)*(altura/100))
            newActivity()
        }

        //AL PULSARSE EL BOTON SE LLAMA A LA FUNCION QUE FINALIZA LA ACTIVIDAD

        btnvolver.setOnClickListener {
            onBackPressed()
        }

    }



    /**
     * Function that recives a button as parameter and changes values based on the buttons id.
     */
   fun buttons(button: FloatingActionButton){
        //Initializes the textViews
       val edadTextView = findViewById<TextView>(R.id.edadTextView)
       val pesoTextView = findViewById<TextView>(R.id.pesoTextView )

        //Uses the button id to add or remove to the age and weight
       when(button.id){
           R.id.edadMinus ->{
               //Receives the default value in the xml
                edad = edadTextView.text.toString().toInt()
               //Ensures that the value can never be less then 1
                edadTextView.text = if(edad > 1){
                    //Removes 1 from the variable
                    (edad-1).toString()
                }else{
                    edad.toString()
                }
            }
           R.id.edadPlus->{
               //Receives the default value in the xml
               edad = edadTextView.text.toString().toInt()
               //Adds 1 to the variable
               edadTextView.text = (edad+1).toString()
           }
           R.id.pesoMinus ->{
               //Receives the default value in the xml
               peso = pesoTextView.text.toString().toInt()
               //Ensures that the value can never be less then 1
               pesoTextView.text = if(peso > 1){
                   //Removes 1 from the variable
                   (peso-1).toString()
               }else{
                   peso.toString()
               }
           }
           R.id.pesoPlus->{
               //Receives the default value in the xml
               peso = pesoTextView.text.toString().toInt()
               //Adds 1 to the variable
               pesoTextView.text = (peso+1).toString()
           }
       }
   }

    /**
     * Uses Intent to open a new activity and sends the result of the Imc to it.
     */
    fun newActivity(){
        //function that receives the name of the Activity to open as a parameter
        val intent = Intent(applicationContext,Activity_imc2::class.java)
        //Sends the value of the Imc to the new activity
        intent.putExtra("resultado",resultado)
        //Starts the new activity
        startActivity(intent)
    }
}