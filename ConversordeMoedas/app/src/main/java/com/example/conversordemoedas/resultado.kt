package com.example.conversordemoedas



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado)

        val btn_voltar = findViewById<Button>(R.id.btn_voltar)

        btn_voltar.setOnClickListener{

            val voltarIntent = Intent(this, MainActivity::class.java)
            startActivity(voltarIntent)

        }

    }

    override fun onStart() {
        super.onStart()
        val resultado = findViewById<TextView>(R.id.txt_resultado)
        val result = intent.extras?.getString("result")
        resultado.text = result
    }





}