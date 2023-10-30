package com.example.actividad_04_pmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Activity_main:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        this.setTitle(R.string.barratitulo)
    }


}