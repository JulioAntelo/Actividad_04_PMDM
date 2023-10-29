package com.example.actividad_04_pmdm

class CalculadoraAdri(){

    /**
     * Atributo de la clase Calculadora donde se guardará los numeros introducidos en 'numactual' hasta que se pulse alguna operacion.
     * @property num1
     */


    var num1=0.0

    /**
     * Atributo de la clase Calculadora en el que se guardará el valor de 'numactual2' hasta que, o bien se pulse el boton 'igual'/'operar' o se pulse
     * una operacion anteriormente pulsada.
     * @property num2
     */

    var num2=0.0

    /**
     * Atributo de la clase Calculadora donde se ira guardando los numeros hasta que se pulse una operacion.
     * @property numactual
     */

    var numactual=""

    /**
     * Atributo de la clase Calculadora en el que, una vez guardado el 'numactual' en 'num1' y habiendose pulsado una operacion, se guardaran temporalmente los numeros hasta que
     * se pulse otra operacion o el boton 'igual'//'operar'.
     * @property num2actual
     */

    var num2actual=""

    /**
     * Atributo de la clase Calculadora, en el que dependiendo de que boton se pulse, se asignara un caracter u otro, con el que se realizaran operaciones y se
     * llamará a la correspondiente funcion.
     * @property operacion
     */

    var operacion=""

    /**
     * Atributo de la Clase Calculadora, donde se almacenara el resultado de el calculo realizado en las funciones 'sumar','restar','multiplicar','dividir'.
     * @property resultado
     */

    var resultado=0.0

    /**
     * Atributo Booleano que servira para idenfiticar que parte de codigo se tiene que ejecutar en funcion de su valor, si es true, se ejecutara la parte correspondiente
     * a pedir los valores de numactual. Una vez pulsada una operacion, el valor de numactual pasará a num1, y la el atributo a false.
     * Cuando el valor es false, se ejecuta la parte de codigo en el que se introducen los numeros a numactual2 y una vez pulsado la operacion o el boton 'igual'/'operar' se guarda
     * el valor de 'numactual2' a 'num2'
     * @property estamosennum1
     */

    var estamosennum1=true

    /**
     * c
     */

    var calculonuevo=false

    /**
     * Parametros solicitados para poder realizar la suma de 'num1' y 'num2'
     * @param numero1
     * @param numero2
     */

    fun sumar(numero1:Double,numero2:Double){
        resultado=numero1+numero2
    }

    /**
     * Parametros solicitados para poder realizar la resta de 'num1' y 'num2'
     * @param numero1
     * @param numero2
     */

    fun restar(numero1: Double,numero2: Double){
        resultado=numero1-numero2
    }

    /**
     * Parametros solicitados para poder realizar la multiplicacion de 'num1' y 'num2'
     * @param numero1
     * @param numero2
     */

    fun multiplicar(numero1: Double,numero2: Double){
        resultado=numero1*numero2
    }

    /**
     * Parametros solicitados para poder realizar la division de 'num1' y 'num2'
     * @param numero1
     * @param numero2
     */

    fun dividir(numero1: Double,numero2: Double){
        resultado=numero1/numero2
    }

}