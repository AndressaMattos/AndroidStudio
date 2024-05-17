package com.example.motivation


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import devandroid.cmzeve.motivation

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /*if(supportActionBar != null){
            supportActionBar!!.hide()
        }*/

        val edt_name = findViewById<EditText>(R.id.editName)
        val btn_save = findViewById<Button>(R.id.buttonSave)

        btn_save.setOnClickListener{
            //antes de tratar o vazio
            /*val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)*/

            //verificar se o campo editName não está vazio
            // buscando o valor informado
            val name = edt_name.text.toString()
            //se o valor informado for diferente de vazio
            if(name != ""){
                val shared = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
                shared.edit().putString("name",name).commit()
                //navegar para a MainActivity
                //intent é uma intenção de começar uma nova activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else {
                //se for vazio informar o usuário
                Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
