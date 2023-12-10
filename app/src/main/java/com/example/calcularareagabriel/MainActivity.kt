package com.example.calcularareagabriel


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import android.widget.RadioButton
import java.text.DecimalFormat

import java.util.ArrayList
import kotlin.math.PI


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var Actual = findViewById<ImageView>(R.id.ivActual)
        var Altura = findViewById<TextView>(R.id.tvAltura)
        var Base = findViewById<TextView>(R.id.tvBase)
        var resultado = findViewById<TextView>(R.id.tvResultado)
        var listaFormas = hacerListaFormas()
        var rdBase = findViewById<RadioButton>(R.id.rdBase)
        var rdAltura = findViewById<RadioButton>(R.id.rdAltura)
        var calcular = findViewById<ImageView>(R.id.iv_Calcular)
        var borrar = findViewById<ImageView>(R.id.iv_Borrar)
        val decimalFormat = DecimalFormat("#.00")
        for (i in listaFormas.indices) {
               listaFormas[i].setOnClickListener {
                val desc = listaFormas[i].contentDescription
                Toast.makeText(this, "Forma selecionada: $desc", Toast.LENGTH_SHORT).show()

                Base.visibility = View.VISIBLE
                Altura.visibility = View.VISIBLE
                   resultado.visibility = View.VISIBLE
                   if(desc.equals("cuadrado")){
                        rdBase.visibility= View.INVISIBLE
                       Base.visibility = View.INVISIBLE
                       rdAltura.setText("Lado")
                       if(Altura.text.equals("Radio")||Altura.text.equals("Altura")){
                           Altura.setText("Lado")
                       }
                   }
                   else if(desc.equals("circulo")){

                       rdBase.visibility= View.INVISIBLE
                       Base.visibility = View.INVISIBLE
                       rdAltura.setText("Radio")
                       if(Altura.text.equals("Altura") || Altura.text.equals("Lado")) {
                           Altura.setText("Radio")
                       }

                   }else{

                       rdBase.visibility= View.VISIBLE
                       Base.visibility = View.VISIBLE
                       rdAltura.setText("Altura")
                       if(Altura.text.equals("Radio")|| Altura.text.equals("Lado")){
                           Altura.setText("Altura")
                       }

                   }


                   Actual.setImageDrawable(listaFormas[i].drawable)
                   Actual.visibility= View.VISIBLE
                   Actual.setContentDescription(desc)

              }
    }

        rdBase.setOnClickListener {
            var listaNumeros = hacerListaNumeros()
            for (i in listaNumeros.indices) {
                listaNumeros[i].setOnClickListener {
                    var numero = listaNumeros[i].contentDescription
                    var texto = Base.text.toString()
                    if (texto.length < 11) {
                        if (texto.equals("Base")) {
                            Base.setText(numero.toString())
                        } else {
                            texto += numero.toString()
                            Base.setText(texto)
                        }
                    }
                }
            }
        }


            rdAltura.setOnClickListener {
                var listaNumeros = hacerListaNumeros()
                for (i in listaNumeros.indices) {
                    listaNumeros[i].setOnClickListener {
                        var numero = listaNumeros[i].contentDescription
                        var texto = Altura.text.toString()
                        if (texto.length < 11) {
                            if (texto.equals("Altura") || texto.equals("Radio")|| texto.equals("Lado")) {
                                Altura.setText(numero.toString())
                            } else {
                                texto += numero.toString()
                                Altura.setText(texto)
                            }
                        }
                    }
                }
            }
        calcular.setOnClickListener{

            var tAltura = 0
            var tBase = 0
            var figura =  Actual.contentDescription
            if(Altura.text.toString()!="Altura" && Altura.text.toString()!=("Radio") && Altura.text.toString()!=("")){
                  tAltura  = Altura.text.toString().toInt()

            }else{
                tAltura=1
            }

            if(!Base.text.toString().equals("Base")&&!Base.text.toString().equals("")) {//si no hay valores que agarrar se peta
                 tBase = Base.text.toString().toInt()
                 }


            if(figura.equals("triangulo")){

                resultado.setText(((tBase * tAltura) / 2).toString())
            } else if(figura.equals("cuadrado")){
                resultado.setText((tAltura * tAltura ).toString())
            }else if(figura.equals("pentagono")){
                resultado.setText(String.format("%.2f",calcularAreaPentagono(tAltura.toDouble(),tBase.toDouble())))
            }else if(figura.equals("circulo")){
                resultado.setText(String.format("%.2f", PI * tAltura * tAltura))
            }else if(figura.equals("rectangulo")){
                resultado.setText((tBase * tAltura).toString())
            }else if(figura.equals("hexagono")){
                resultado.setText(((3 * tAltura * tBase).toString()))
            }

        }
        borrar.setOnClickListener{
            Altura.setText("")
            Base.setText("")
            resultado.setText("")
        }

        }
        fun hacerListaFormas(): ArrayList<ImageView> {
            var cuandrado = findViewById<ImageView>(R.id.ivCuadrado)
            var hexagono = findViewById<ImageView>(R.id.ivHexagono)
            var triangulo = findViewById<ImageView>(R.id.ivTriangulo)
            var circulo = findViewById<ImageView>(R.id.ivCirculo)
            var pentagono = findViewById<ImageView>(R.id.ivPentagono)
            var rectangulo = findViewById<ImageView>(R.id.ivRectangulo)

            var Formas = ArrayList<ImageView>()
            Formas.add(cuandrado)
            Formas.add(hexagono)
            Formas.add(triangulo)
            Formas.add(circulo)
            Formas.add(pentagono)
            Formas.add(rectangulo)
            return Formas
        }

        fun hacerListaNumeros(): ArrayList<ImageView> {
            var _0 = findViewById<ImageView>(R.id.iv_0)
            var _1 = findViewById<ImageView>(R.id.iv_1)
            var _2 = findViewById<ImageView>(R.id.iv_2)
            var _3 = findViewById<ImageView>(R.id.iv_3)
            var _4 = findViewById<ImageView>(R.id.iv_4)
            var _5 = findViewById<ImageView>(R.id.iv_5)
            var _6 = findViewById<ImageView>(R.id.iv_6)
            var _7 = findViewById<ImageView>(R.id.iv_7)
            var _8 = findViewById<ImageView>(R.id.iv_8)
            var _9 = findViewById<ImageView>(R.id.iv_9)

            var numeros = ArrayList<ImageView>()
            numeros.add(_0)
            numeros.add(_1)
            numeros.add(_2)
            numeros.add(_3)
            numeros.add(_4)
            numeros.add(_5)
            numeros.add(_6)
            numeros.add(_7)
            numeros.add(_8)
            numeros.add(_9)
            return numeros

        }
    fun calcularAreaPentagono(base: Double, altura: Double): Double {
        val perimetro = 5 * base // En un pentágono regular, todos los lados tienen la misma longitud
        val apotema = altura / (2 * Math.tan(Math.PI / 5)) // Fórmula para calcular el apotema en un pentágono regular

        val area = (perimetro * apotema) / 2

        return area
    }
    }



