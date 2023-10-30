package com.example.actividad_04_pmdm

class Calculo_julio {var num1: Float = 0f
    var num2: Float = 0f
    var op: Int = 0
    var result: Float = 0f

    //si el primerNum es falso es porque se esta escribiendo el numtemp2
    var primerNum: Boolean = true 
    var numTemp1: String = ""
    var numTemp2: String = ""
    var numCalculos: Int = 0


    fun calcular() {
        when (this.op) {
            0 -> this.suma()
            1 -> this.resta()
            2 -> this.multiplicar()
            3 -> this.divide()
        }
        this.numCalculos += 1
    }

    fun suma() {
        this.result = this.num1 + this.num2
    }

    fun resta() {
        this.result = this.num1 - this.num2
    }

    fun multiplicar() {
        this.result = this.num1 * this.num2
    }

    fun divide() {
        this.result = this.num1 / this.num2
    }

    fun operadorTxt(num: Int): String {
        return when (num) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> ""
        }
    }


    fun operadorTxt(): String {
        return when (this.op) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> ""
        }
    }

    fun tecleaDigito(num : Int) {

        if (num < 10){
            if (this.primerNum) this.numTemp1 += num.toString()
            else this.numTemp2 += num.toString()
        }
        else {
            if (this.primerNum) {
                if (this.numTemp1 == "") this.numTemp1 = "0."
                else this.numTemp1 += this.numTemp1
            }
            else {
                if (this.numTemp2 == "") this.numTemp2 = "0."
                else this.numTemp2 += this.numTemp2
            }

        }
    }


    fun ResetValores(resetNumCalculos: Boolean = true, resetResult: Boolean = true){
        this.num1 = 0f
        this.num2 = 0f
        this.op = 0
        if (resetResult) this.result = 0f
        this.primerNum = true
        this.numTemp1 = ""
        this.numTemp2 = ""
        if (resetNumCalculos) this.numCalculos = 0
    }


}