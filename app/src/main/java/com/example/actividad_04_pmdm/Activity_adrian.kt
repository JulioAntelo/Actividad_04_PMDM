package com.example.actividad_04_pmdm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Activity_adrian : AppCompatActivity() {


    //FUNCION QUE FINALIZA LA ACTIVIDAD ACTUAL
    fun volveratras(){
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_adri)


        /**
         * @author AdrianPRG
         */


        var calcu = CalculadoraAdri()

        /**
         * Variables del Activity main: NUMEROS
         * Conectadas cada una con el correspondiente ID de los botones
         */

        val cero = findViewById<Button>(R.id.cero)
        val uno = findViewById<Button>(R.id.uno)
        val dos = findViewById<Button>(R.id.dos)
        val tres = findViewById<Button>(R.id.tres)
        val cuatro = findViewById<Button>(R.id.cuatro)
        val cinco = findViewById<Button>(R.id.cinco)
        val seis = findViewById<Button>(R.id.seis)
        val siete = findViewById<Button>(R.id.siete)
        val ocho = findViewById<Button>(R.id.ocho)
        val nueve = findViewById<Button>(R.id.nueve)

        /**
         * Variables del Activity main: OPERACIONES/RESULTADO/BORRAR
         * Conectadas cada una con el correspondiente ID de los botones
         */

        var botonsumar = findViewById<Button>(R.id.sumar)
        var botonrestar = findViewById<Button>(R.id.restar)
        var botonmulti = findViewById<Button>(R.id.multiplicar)
        var botondivi = findViewById<Button>(R.id.dividir)
        var borrar = findViewById<Button>(R.id.borrar)
        var operar = findViewById<Button>(R.id.operar)
        var mostrar = findViewById<TextView>(R.id.mostrar)

        //Boton que servira para volver atras

        var btnvolver:Button=findViewById(R.id.volveratras)


        //Al hacerse click en el boton volver, se llama a la funcion 'volveratras' para volver al menu principal

        btnvolver.setOnClickListener { volveratras() }


        /**
         * Funcion que restablece todos los valores a su inicio, menos el resultado.
         */


        fun restablecimientodevalores() {
            calcu.num1 = 0.0
            calcu.num2 = 0.0
            calcu.numactual = ""
            calcu.num2actual = ""
            calcu.operacion = ""
            calcu.resultado=0.0
        }

        fun restablecimientovaloressinresultado(){
            calcu.num1=0.0
            calcu.num2=0.0
            calcu.numactual=""
            calcu.num2actual=""
            calcu.operacion=""
        }



        /***
         * Funcion OPCIONAL que restablece el valor de 'num2','numactual' y 'numactual2' una vez se pulsa el boton 'igual'/'operar' y se tiene tanto 'num1' como 'num2'.
         */

        fun restablecimientovaloressinnum1nioperacion() {
            calcu.num2 = 0.0
            calcu.numactual = ""
            calcu.num2actual = ""
        }

        /**
         * Funcion que, al ser invocada, segun la operacion, llamara a su correspondiente funcion y la ejecutará
         */

        fun queoperacion() {
            when (calcu.operacion) {
                "+" -> {
                    calcu.sumar(calcu.num1, calcu.num2)
                }
                "-" -> {
                    calcu.restar(calcu.num1, calcu.num2)
                }
                "x" -> {
                    calcu.multiplicar(calcu.num1, calcu.num2)
                }
                "/" -> {
                    calcu.dividir(calcu.num1, calcu.num2)
                }
            }
        }

        /**
         * Funcion donde se ejecuta el codigo principal
         */

        @SuppressLint("SuspiciousIndentation")
        fun calcularnum1onum2() {
            /**
             * Al llamar la funcion, si el atributo 'estamosennum1' es true, se ejecutará el otro de codigo dentro de la condicion, si no,
             * se ejecutara el codigo de la otra condicion
             * Para cada numero conectado a su boton mediante id, cuando se pulsa el boton, se añade el numero correspondiente a 'numactual'
             */
            if (calcu.estamosennum1 == true) {
                    cero.setOnClickListener {
                        calcu.numactual += "0"
                        mostrar.setText(calcu.numactual)
                    }
                    uno.setOnClickListener {
                        calcu.numactual += "1"
                        mostrar.setText(calcu.numactual)
                    }
                    dos.setOnClickListener {
                        calcu.numactual += "2"
                        mostrar.setText(calcu.numactual)
                    }
                    tres.setOnClickListener {
                        calcu.numactual += "3"
                        mostrar.setText(calcu.numactual)
                    }
                    cuatro.setOnClickListener {
                        calcu.numactual += "4"
                        mostrar.setText(calcu.numactual)
                    }
                    cinco.setOnClickListener {
                        calcu.numactual += "5"
                        mostrar.setText(calcu.numactual)
                    }
                    seis.setOnClickListener {
                        calcu.numactual += "6"
                        mostrar.setText(calcu.numactual)
                    }
                    siete.setOnClickListener {
                        calcu.numactual += "7"
                        mostrar.setText(calcu.numactual)
                    }
                    ocho.setOnClickListener {
                        calcu.numactual += "8"
                        mostrar.setText(calcu.numactual)
                    }
                    nueve.setOnClickListener {
                        calcu.numactual += "9"
                        mostrar.setText(calcu.numactual)
                    }
                    borrar.setOnClickListener {
                        calcu.numactual = ""
                        mostrar.setText("")
                        calcularnum1onum2()
                    }
                    /**
                     * En los botones de sumar,restar,multiplicar y dividir, al ser pulsado, primero se comprobara si se ha introducido algun
                     * numero en el atributo 'numactual', si no es asi, no se puede continuar, en cambio, si se ha introducido numero
                     * el numero actual pasará a numero1, el Textview que contiene el numactual se pondra a '""', la operacion que se guardará sera la del
                     * boton correspondiente. El atributo booleano pasará a ser false, ya que 'num1' ya ha sido introducido, y para poder ejecutar el otro trozo
                     * de codigo llamaremos de nuevo a la funcion
                     */
                    botonsumar.setOnClickListener {
                        if (calcu.numactual == "") {
                            println("AUN NO SE HA INTRODUCIDO NINGUN NUMERO, NO SE PUEDE SUMAR")
                        } else if (calcu.numactual != "") {
                            calcu.num1 = calcu.numactual.toDouble()
                            calcu.numactual = ""
                            mostrar.setText("")
                            calcu.operacion = "+"
                            calcu.estamosennum1 = false
                            calcularnum1onum2()
                        }
                    }
                    botonrestar.setOnClickListener {
                        if (calcu.numactual == "") {
                            println("AUN NO SE HA INTRODUCIDO NINGUN NUMERO,NO SE PUEDE RESTAR")
                        } else if (calcu.numactual != "") {
                            calcu.num1 = calcu.numactual.toDouble()
                            calcu.numactual = ""
                            mostrar.setText("")
                            calcu.operacion = "-"
                            calcu.estamosennum1 = false
                            calcularnum1onum2()
                        }
                    }
                    botonmulti.setOnClickListener {
                        if (calcu.numactual == "") {
                            println("AUN NO SE HA INTRODUCIDO NINGUN NUMERO, NO SE PUEDE MULTIPLICAR")
                        } else if (calcu.numactual != "") {
                            calcu.num1 = calcu.numactual.toDouble()
                            calcu.numactual = ""
                            mostrar.setText("")
                            calcu.operacion = "x"
                            calcu.estamosennum1 = false
                            calcularnum1onum2()
                        }
                    }
                    botondivi.setOnClickListener {
                        if (calcu.numactual == "") {
                            println("AUN NO SE HA INTRODUCIDO NINGUN NUMERO, NO SE PUEDE DIVIDIR")
                        } else if (calcu.numactual != "") {
                            calcu.num1 = calcu.numactual.toDouble()
                            calcu.numactual = ""
                            mostrar.setText("")
                            calcu.operacion = "/"
                            calcu.estamosennum1 = false
                            calcularnum1onum2()
                        }
                    }
                    /**
                     * Al darle a 'operar', como aun no hay valor ni para num1 ni para num2 no se puede realizar el calculo, por lo tanto saldra
                     * un aviso Toast, indicando que se debe introducir los dos numeros y la operacion
                     */
                    operar.setOnClickListener {
                        Toast.makeText(
                            applicationContext,
                            "DEBE INTRODUCIR DOS NUMEROS",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                else if (calcu.estamosennum1 == false) {

                    if (calcu.calculonuevo==true){
                        cero.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="0"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        uno.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="1"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        dos.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="2"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        tres.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="3"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        cuatro.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="4"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        cinco.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="5"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        seis.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="6"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        siete.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="7"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        ocho.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="8"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                        nueve.setOnClickListener {
                            restablecimientodevalores()
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            mostrar.setText("")
                            calcu.numactual+="9"
                            calcularnum1onum2()
                            mostrar.setText(calcu.numactual)
                        }
                    }
                    else{
                        cero.setOnClickListener {
                            calcu.num2actual += "0"
                            mostrar.setText(calcu.num2actual)
                        }
                        uno.setOnClickListener {
                            calcu.num2actual += "1"
                            mostrar.setText(calcu.num2actual)
                        }
                        dos.setOnClickListener {
                            calcu.num2actual += "2"
                            mostrar.setText(calcu.num2actual)
                        }
                        tres.setOnClickListener {
                            calcu.num2actual += "3"
                            mostrar.setText(calcu.num2actual)
                        }
                        cuatro.setOnClickListener {
                            calcu.num2actual += "4"
                            mostrar.setText(calcu.num2actual)
                        }
                        cinco.setOnClickListener {
                            calcu.num2actual += "5"
                            mostrar.setText(calcu.num2actual)
                        }
                        seis.setOnClickListener {
                            calcu.num2actual += "6"
                            mostrar.setText(calcu.num2actual)
                        }
                        siete.setOnClickListener {
                            calcu.num2actual += "7"
                            mostrar.setText(calcu.num2actual)
                        }
                        ocho.setOnClickListener {
                            calcu.num2actual += "8"
                            mostrar.setText(calcu.num2actual)
                        }
                        nueve.setOnClickListener {
                            calcu.num2actual += "9"
                            mostrar.setText(calcu.num2actual)
                        }
                        /**
                         * Para borrar, se restablecerán todos los valores, ademas de que, para que se pueda volver a introducir num1, es necesario que el atributo 'estamosennum1'
                         * sea true, por lo tanto se cambia a true y se vuelve a llamar a la funcion
                         */
                        borrar.setOnClickListener {
                            restablecimientodevalores()
                            calcu.resultado = 0.0
                            mostrar.setText("")
                            calcu.estamosennum1=true
                            calcu.calculonuevo=false
                            calcularnum1onum2()
                        }
                        /**
                         * En los botones de sumar,restar,multiplicar,dividir, ahora que estamos en num2, se realizaran las siguientes ejecuciones:
                         * 1º Comprobar si ya se ha realizado una operacion anteriormente,mirando si resultado es nulo,ya que uno de los requisitos
                         * es poder calcular num1 y num2 (si ya estos tienen valor), pulsando otra vez uno de los botones de operaciones,
                         * en ese caso, se imprimira "OPERACION", lo cual resulta util observarlo en el apartado Logcat
                         * para llevar un control de como funciona el programa.
                         *
                         * 2º Comprobando si se trata de un paso de 'numactual' a 'num2' ya habiendo obtenido un resultado (siendo esta una segunda operacion despues de pulsar '='),
                         * o un primer calculo, ya que el boton puede servir tanto para cortar 'numactual' a 'num2'
                         * como para calcular (si este es pulsado de nuevo teniendo num1 y num2 valores).
                         *
                         *3º FUNCIONAMIENTO: 'numactual2' pasa a 'num2', se realiza la operacion, y el resultado pasa a num1.
                         * Ya que se ha pulsado, la operacion asignada es la correspondiente al boton, se restablecen los valores, menos 'operacion', y 'num1',
                         * que es donde se guardará el resultado, finalmente este se muestra en pantalla
                         */
                        botonsumar.setOnClickListener {
                            if (calcu.resultado != null) {
                                if (calcu.num2actual == "") {
                                    println("OPERACION")
                                    mostrar.setText("")
                                } else
                                    calcu.num2 = calcu.num2actual.toDouble()
                                queoperacion()
                                calcu.num1 = calcu.resultado
                                calcu.operacion = "+"
                                restablecimientovaloressinnum1nioperacion()
                                mostrar.setText(calcu.num1.toString())
                            }

                        }
                        botonrestar.setOnClickListener {
                            if (calcu.resultado != null) {
                                if (calcu.num2actual == "") {
                                    println("OPERACION")
                                } else
                                    calcu.num2 = calcu.num2actual.toDouble()
                                queoperacion()
                                calcu.num1 = calcu.resultado
                                calcu.operacion = "-"
                                restablecimientovaloressinnum1nioperacion()
                                mostrar.setText(calcu.num1.toString())
                            }
                        }
                        botonmulti.setOnClickListener {
                            if (calcu.resultado != null) {
                                if (calcu.num2actual == "") {
                                    println("OPERACION")
                                } else
                                    calcu.num2 = calcu.num2actual.toDouble()
                                queoperacion()
                                calcu.num1 = calcu.resultado
                                calcu.operacion = "x"
                                restablecimientovaloressinnum1nioperacion()
                                mostrar.setText(calcu.num1.toString())
                            }
                        }
                        botondivi.setOnClickListener {
                            if (calcu.resultado != null) {
                                if (calcu.num2actual == "") {
                                    println("OPERACION")
                                } else
                                    calcu.num2 = calcu.num2actual.toDouble()
                                queoperacion()
                                calcu.num1 = calcu.resultado
                                calcu.operacion = "/"
                                restablecimientovaloressinnum1nioperacion()
                                mostrar.setText(calcu.num1.toString())
                            }
                        }
                        /**
                         * Primero, se comprueba si se tienen los dos numeros, si no es asi, salta un mensaje Toast, de que debe de haber almenos dos numeros.
                         * En los botones de calculo no hace falta poner Toast, ya que su uso es para darle a 'num2' un valor o bien para realizar un calculo si ya se tienen los dos numeros.
                         * Si se tienen los dos numeros, numactual pasa a num2 , se llama a la funcion para realizar la operacion, se restablecen los valores, y num1 obtiene el valor de resultado.
                         * Esto ultimo sirve por si se desea seguir realizando operaciones.
                         */
                        operar.setOnClickListener {
                            if (calcu.num2actual == "") {
                                Toast.makeText(
                                    applicationContext,
                                    "DEBE INTRODUCIR DOS NUMEROS, SOLO LLEVA 1 Y UNA OPERACION",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else
                                calcu.num2 = calcu.num2actual.toDouble()
                            calcu.num2actual = ""
                            mostrar.setText("")
                            queoperacion()
                            calcu.num1 = calcu.resultado
                            mostrar.setText(calcu.num1.toString())
                            restablecimientovaloressinresultado()
                            calcu.calculonuevo=true
                            calcularnum1onum2()
                        }
                    }
            }
        }
        /**
         * Se llama a la funcion que contiene el codigo.
         */
        
        calcularnum1onum2()
    }
}

