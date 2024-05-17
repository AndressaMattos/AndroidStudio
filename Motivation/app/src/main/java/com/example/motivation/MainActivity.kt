package com.example.motivation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.MotivationConstants.FraseFilter.FELIZ
import com.example.motivation.infra.MotivationConstants.FraseFilter.INFINITO
import com.example.motivation.infra.MotivationConstants.FraseFilter.SOL
import com.example.motivation.Repository.Mock
//import devandroid.cmzeve.motivation.R
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private var mFraseFilter : Int = MotivationConstants.FraseFilter.INFINITO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val txt_name = findViewById<TextView>(R.id.textName)
        val txt_frase = findViewById<TextView>(R.id.textFrase)
        val img_infinito = findViewById<ImageView>(R.id.imageInfinito)
        val img_feliz = findViewById<ImageView>(R.id.imageFeliz)
        val img_sol = findViewById<ImageView>(R.id.imageSol)
        val btn_nfraze = findViewById<Button>(R.id.buttonNovaFrase)

        val shared = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
        txt_name.text = shared.getString("name", "")

        img_infinito.setColorFilter(resources.getColor(R.color.white))
        txt_frase.text = Mock().getFrase(mFraseFilter)

        img_infinito.setOnClickListener {
            img_infinito.setColorFilter(resources.getColor(R.color.colorAccent))
            mFraseFilter = MotivationConstants.FraseFilter.INFINITO
        }
        img_feliz.setOnClickListener {
            img_feliz.setColorFilter(resources.getColor(R.color.colorAccent))
            mFraseFilter = MotivationConstants.FraseFilter.FELIZ
        }
        img_sol.setOnClickListener {
            img_sol.setColorFilter(resources.getColor(R.color.colorAccent))
            mFraseFilter = MotivationConstants.FraseFilter.SOL
        }

        btn_nfraze.setOnClickListener {
            img_infinito.setColorFilter(resources.getColor(R.color.white))
            img_feliz.setColorFilter(resources.getColor(R.color.white))
            img_sol.setColorFilter(resources.getColor(R.color.white))

            when (mFraseFilter) {
                INFINITO -> {
                    //deixando as imagens rosa claro ao clicar
                    img_infinito.setColorFilter(resources.getColor(R.color.colorAccent))
                    //atualiza com a categoria selecionada
                    mFraseFilter = MotivationConstants.FraseFilter.INFINITO
                }

                FELIZ -> {
                    img_feliz.setColorFilter(resources.getColor(R.color.colorAccent))
                    //atualiza com a categoria selecionada
                    mFraseFilter = MotivationConstants.FraseFilter.FELIZ
                }

                SOL -> {
                    img_sol.setColorFilter(resources.getColor(R.color.colorAccent))
                    //atualiza com a categoria selecionada
                    mFraseFilter = MotivationConstants.FraseFilter.SOL
                }

            }
            txt_frase.text = Mock().getFrase(mFraseFilter)
        }
    }
}
