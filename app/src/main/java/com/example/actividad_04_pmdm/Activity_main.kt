package com.example.actividad_04_pmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity_main : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__main)


        /**
         * @param actividad
         * Esta funcion recibe una actividad, y cuando se pulse el boton correspondiente ira hacia la actividad
         * pasada por parametros, mediante el Intent
         */

        fun IrAactividad(actividad:Activity){
            val intento=Intent(this,actividad::class.java)
            startActivity(intento)
        }

        //Funcion para cerrar la app

        fun cerrarApp(){
            finish()
        }

        //Botones que al ser pulsados llamaran a las funciones correspondientes

        val botonIMC:Button=findViewById(R.id.imc)
        val botonCALC1:Button=findViewById(R.id.calc1)
        val botonCALC2:Button=findViewById(R.id.calc2)
        val botonCALC3:Button=findViewById(R.id.calc3)
        val botoncerrar:Button=findViewById(R.id.botonsalir)


        //Funcion que contiene el codigo de cada boton

        fun presionadoboton(){
            botonIMC.setOnClickListener {
                IrAactividad(Activity_imc())
            }
            botonCALC1.setOnClickListener {
                IrAactividad(Activity_adrian())
            }
            botonCALC2.setOnClickListener{
                IrAactividad(Activity_moise())
            }
            botonCALC3.setOnClickListener {
                IrAactividad(Activity_julio())
            }
            botoncerrar.setOnClickListener {
                cerrarApp()
            }
        }

        //SE LLAMA A LA FUNCION
        presionadoboton()

    }



}