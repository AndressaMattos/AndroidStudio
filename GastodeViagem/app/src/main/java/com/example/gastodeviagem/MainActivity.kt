package com.example.gastodeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edt_distancia = findViewById<EditText>(R.id.etx_distancia)
        val edt_preco = findViewById<EditText>(R.id.etx_preco)
        val edt_autonomia = findViewById<EditText>(R.id.etx_autonomia)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
       // val txt_resultado = findViewById<TextView>(R.id.txt_resultado)


        btn_calcular.setOnClickListener {

            if (edt_distancia.text.toString().isEmpty()) {
                edt_distancia.error = "Preencha uma distância"
            } else if (edt_preco.text.toString().isEmpty()) {
                edt_preco.error = "Preencha um Preço"
            } else if (edt_autonomia.text.toString().isEmpty()) {
                edt_autonomia.error = "Preencha uma Autonomia"
            } else {
                val distancia = edt_distancia.text.toString().toDouble()
                val preco = edt_distancia.text.toString().toDouble()
                val autonomia = edt_autonomia.text.toString().toDouble()
                var result = 0.00 as Double

                if (distancia <= 0.0) {
                    Toast.makeText(
                        this, "Informe Distância Válida!",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (preco <= 0.0) {
                    Toast.makeText(
                        this, "Informe um Preço Válido!",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (autonomia <= 0.0) {
                    Toast.makeText(
                        this, "Informe uma Autonomia Válida!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {

                    result = preco * (distancia / autonomia)

                    //txt_resultado.text = String.format("R$ %.2f", result)

                    val resultadoIntent = Intent(this, Calc_Resultado::class.java)
                    resultadoIntent.putExtra("result", "R$ " +String.format("%.2f", result))
                    startActivity(resultadoIntent)
                }
            }
        }
    }
}