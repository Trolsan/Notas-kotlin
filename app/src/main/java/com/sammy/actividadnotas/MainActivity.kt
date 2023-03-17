package com.sammy.actividadnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var campoNombre: EditText?=null
    var txtResultado: TextView?=null
    var campoNota1: EditText?=null
    var campoNota2: EditText?=null
    var campoNota3: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre= findViewById(R.id.idNombre)
        txtResultado= findViewById(R.id.idResultado)
        campoNota1= findViewById(R.id.nota1)
        campoNota2= findViewById(R.id.nota2)
        campoNota3= findViewById(R.id.nota3)

        val btnCalcular: Button =findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{Calcular()}

    }

    private fun Calcular() {

        val campoNombre:EditText=findViewById(R.id.idNombre)
        val campoNota1:EditText=findViewById(R.id.nota1)
        val campoNota2:EditText=findViewById(R.id.nota2)
        val campoNota3:EditText=findViewById(R.id.nota3)

        val nota1:Double=campoNota1.text.toString().toDouble()
        val nota2:Double=campoNota2.text.toString().toDouble()
        val nota3:Double=campoNota3.text.toString().toDouble()

        var prom:Double=(nota1+nota2+nota3)/3

        println("Promedio: "+prom)
        Log.i("Salida","Promedio: $prom")

        var result=""
        var resultadoColor="";

        if (nota1 > 5 || nota2 > 5 || nota3 > 5 || nota1 < 0 || nota2 < 0 || nota3 < 0){
            Toast.makeText( this, "Solo ingresa numeros de 0 a 5", Toast.LENGTH_SHORT).show()
            finish()
        }else{
            if(prom>=3.5){
                Log.i("Salida",result)
                result="Gano en $prom "
                resultadoColor="GANA"
            }else{
                Log.i("Salida","Perdio en $prom")
                result="Perdio en $prom"
                resultadoColor="PIERDE"
            }
        }


        //Creamos el intent encargado de la comunicacion entre activities
        val intent = Intent(this, ResultadoActivity::class.java)
        //creamos el bundle para el paso de informacion entre activies
        val miBundle: Bundle = Bundle()
        miBundle.putString("Nombre",campoNombre!!.text.toString())
        miBundle.putString("Nota 1",campoNota1!!.text.toString())
        miBundle.putString("Nota 2",campoNota2!!.text.toString())
        miBundle.putString("Nota 3",campoNota3!!.text.toString())
        miBundle.putString("Resultado",result!!.toString())
        miBundle.putString("color",resultadoColor!!.toString())
        intent.putExtras(miBundle)
        //Iniciamos el llamado a la nueva actividad
        startActivity(intent)
    }

}