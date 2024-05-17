package com.example.projeto2imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IMC_Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_imc_resultado)
    }

    override fun onStart() {
        super.onStart()

        val resultado = findViewById<TextView>(R.id.txt_resultado)
      //  val result = intent.extras?.getString("result")
        var mensagem= findViewById<TextView>(R.id.txt_texto)
        val voltar = findViewById<Button>(R.id.btn_voltar)

        val imc_result = intent.extras?.getString("result")
        resultado.text = "IMC:" + imc_result

        val Imc = imc_result.toString().toDouble()

        if (Imc <16)
            mensagem.text = "Sem Classificação"

        else if (Imc >=16 && Imc<=16.9)
            mensagem.text = "Muito abaixo do peso"

        else if (Imc >=17 && Imc<=18.4)
            mensagem.text = "Abaixo do peso"

        else if (Imc >=18.5 && Imc<=24.9)
            mensagem.text = "Peso Normal"

        else if (Imc >=25 && Imc<=29.9)
            mensagem.text = "Acima do peso"

        else if (Imc >=30 && Imc<=34.9)
            mensagem.text = "Obsidade de Grau I"

        else if (Imc >40)
            mensagem.text = "Obsidade de Grau II"


        voltar.setOnClickListener{
            val voltarIntent = Intent(this, MainActivity::class.java)
            voltarIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(voltarIntent)

        }
    }

}