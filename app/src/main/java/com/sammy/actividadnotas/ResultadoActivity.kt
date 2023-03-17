package com.sammy.actividadnotas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val campoNombre = findViewById<TextView>(R.id.txtNombre)
        val campoNota1 = findViewById<TextView>(R.id.Nota1)
        val campoNota2 = findViewById<TextView>(R.id.Nota2)
        val campoNota3 = findViewById<TextView>(R.id.Nota3)
        val resulta = findViewById<TextView>(R.id.textView5)
        var color = ""

        //Recuperamos la informacion que llega en el intent
        var miBundle: Bundle? = this.intent.extras

        //Se asigna la informacion obtenida al textView
        if (miBundle != null) {
            campoNombre.text = "Notas de ${miBundle.getString("Nombre")}"
            campoNota1.text = "${miBundle.getString("Nota 1")}"
            campoNota2.text = "${miBundle.getString("Nota 2")}"
            campoNota3.text = "${miBundle.getString("Nota 3")}"
            resulta.text = "${miBundle.getString("Resultado")}"
            color = "${miBundle.getString("color")}"

            if (color.equals("GANA")) {
                resulta.setTextColor(Color.GREEN)
            } else {
                resulta.setTextColor(Color.RED)
            }
        }

        val btnSalir: Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener { onClick() }
    }

    private fun onClick() {
        finish()
    }
}