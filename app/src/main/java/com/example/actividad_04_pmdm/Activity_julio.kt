package com.example.actividad_04_pmdm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Activity_julio : AppCompatActivity() {

    private lateinit var Texto1: TextView
    private lateinit var Texto2: TextView

    private lateinit var btnNum: ArrayList<Button>
    private lateinit var btnOper: ArrayList<Button>

    private lateinit var btnCE: Button
    private lateinit var btnResult: Button
    private lateinit var btnBorrar: Button

    private lateinit var ObjCalc: Calculo_julio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_julio)

        ObjCalc = Calculo_julio()

        initComponents()
        initListeners()

        fun volveratras(){
            finish()
        }

        val btnvolver:Button=findViewById(R.id.volvercalc3)

        btnvolver.setOnClickListener {
            volveratras()
        }


    }


    private fun initComponents() {
        Texto1 = findViewById(R.id.textView1)
        Texto2 = findViewById(R.id.textView2)

        btnCE = findViewById(R.id.button)
        btnResult = findViewById(R.id.buttonEquals)
        btnBorrar = findViewById(R.id.buttonBorrar)

        Texto1.text = ""
        Texto2.text = ""

        initBtnNum()
        initBtnOper()
    }

    private fun initBtnNum() {
        btnNum = ArrayList()
        btnNum.add(findViewById(R.id.button0))
        btnNum.add(findViewById(R.id.button1))
        btnNum.add(findViewById(R.id.button2))
        btnNum.add(findViewById(R.id.button3))
        btnNum.add(findViewById(R.id.button4))
        btnNum.add(findViewById(R.id.button5))
        btnNum.add(findViewById(R.id.button6))
        btnNum.add(findViewById(R.id.button7))
        btnNum.add(findViewById(R.id.button8))
        btnNum.add(findViewById(R.id.button9))
        btnNum.add(findViewById(R.id.buttonComa))
    }

    private fun initBtnOper() {
        btnOper = ArrayList()
        btnOper.add(findViewById(R.id.buttonPlus))
        btnOper.add(findViewById(R.id.buttonMinus))
        btnOper.add(findViewById(R.id.buttonMultiply))
        btnOper.add(findViewById(R.id.buttonDivision))
    }

    private fun initListeners() {
        for (i in 0..<btnNum.count()) {
            btnNum[i].setOnClickListener { btnNumClicked(i) }
        }

        for (i in 0..<btnOper.count()) {
            btnOper[i].setOnClickListener { btnOperClicked(i) }
        }

        btnCE.setOnClickListener { BottonBorrarTodo() }
        btnResult.setOnClickListener { BottonResultado() }
        btnBorrar.setOnClickListener { BottonBorrar() }
    }

    private fun btnNumClicked(num: Int) {
        ObjCalc.tecleaDigito(num)

        if (ObjCalc.primerNum) {
            muestraValor(ObjCalc.numTemp1, ObjCalc.numTemp1)
        } else {
            muestraValor(ObjCalc.numTemp2, ObjCalc.numTemp1 + ObjCalc.operadorTxt() + ObjCalc.numTemp2)
        }
    }

    private fun btnOperClicked(num: Int) {
        if (ObjCalc.primerNum) {

            if (ObjCalc.numCalculos > 0 && ObjCalc.numTemp1 == "") {
                ObjCalc.num1 = ObjCalc.result
                ObjCalc.numTemp1 = ObjCalc.result.toString()
            } else {
                ObjCalc.num1 = ObjCalc.numTemp1.toFloat()
            }

            ObjCalc.op = num
            muestraValor(ObjCalc.operadorTxt(), ObjCalc.numTemp1 + ObjCalc.operadorTxt())
            ObjCalc.numTemp2 = ""
            ObjCalc.primerNum = false
        } else if (ObjCalc.numTemp2 == "") {

            ObjCalc.op = num
            muestraValor(ObjCalc.operadorTxt(), ObjCalc.numTemp1 + ObjCalc.operadorTxt())
        } else {

            ObjCalc.num2 = ObjCalc.numTemp2.toFloat()


            ObjCalc.calcular()

            muestraValor(ObjCalc.operadorTxt(num), ObjCalc.result.toString() + ObjCalc.operadorTxt(num))

            ObjCalc.num1 = ObjCalc.result
            ObjCalc.op = num
            ObjCalc.num2 = 0f
            ObjCalc.numTemp1 = ObjCalc.num1.toString()
            ObjCalc.numTemp2 = ""
        }
    }

    fun BottonBorrarTodo() {
        muestraValor("", "")

        ObjCalc.ResetValores()
    }

    fun BottonBorrar() {
        if (ObjCalc.numTemp1.isNotEmpty()) {
            ObjCalc.numTemp1 = ObjCalc.numTemp1.dropLast(1)
            muestraValor(ObjCalc.numTemp1, ObjCalc.numTemp1)
        }
        else
            if(ObjCalc.numTemp2.isNotEmpty()){
                ObjCalc.numTemp2 = ObjCalc.numTemp2.dropLast(1)
                muestraValor(ObjCalc.numTemp2, txtTexto2 = "${ObjCalc.num1}${ObjCalc.operadorTxt()}${ObjCalc.numTemp2}")
            } else
                if(ObjCalc.numTemp2.isEmpty() || ObjCalc.num1.toString().isNotEmpty())
                    muestraValor(ObjCalc.operadorTxt(), txtTexto2 = "${ObjCalc.num1}${ObjCalc.operadorTxt()}")

        if(ObjCalc.numTemp1.isEmpty())
            mensajeError("No existe nada para borrar")
    }

    fun BottonResultado(){
        if (!ObjCalc.primerNum && ObjCalc.numTemp2 != ""){
            ObjCalc.num2 = ObjCalc.numTemp2.toFloat()
            ObjCalc.calcular()

            muestraValor(ObjCalc.result.toString(), ObjCalc.num1.toString() + ObjCalc.operadorTxt() + ObjCalc.num2.toString() + "=" + ObjCalc.result.toString())

            ObjCalc.ResetValores(resetNumCalculos = false, resetResult = false)
        }
        else {
            mensajeError("debe introducir 2 numeros y una operacion para mostrar un resultado")
        }
    }

    fun muestraValor(txtTexto1 : String, txtTexto2 : String){
        Texto1.text = getString(R.string.texto1, txtTexto1)
        Texto2.text = getString(R.string.texto2, txtTexto2)
    }

    fun mensajeError(msj: String) {
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show()
    }
}