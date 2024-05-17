package com.example.conversordemoedas


import android.content.Intent

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordemoedas.api.Endpoint
import com.example.conversordemoedas.util.NetworkUtil
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var spFrom : Spinner
    private lateinit var spTo : Spinner
    private lateinit var btConvert : Button
    private lateinit var tvResult : TextView
    private lateinit var etValueFrom : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spFrom = findViewById(R.id.spFrom)
        spTo = findViewById(R.id.spTo)
        btConvert = findViewById(R.id.btConvert)
        tvResult = findViewById(R.id.tvResult)
        etValueFrom = findViewById(R.id.etValueFrom)

        getCurrencies()

        btConvert.setOnClickListener {
            convertMoney()

        }
    }

    fun convertMoney(){
        val retrofitClient = NetworkUtil.getRetrofitInstance("https://cdn.jsdelivr.net/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getCurrencyRate(spFrom.selectedItem.toString(), spTo.selectedItem.toString()).enqueue(object :
            retrofit2.Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = response.body()?.entrySet()?.find { it.key == spTo.selectedItem.toString() }
                val rate : Double = data?.value.toString().toDouble()
                val conversion = etValueFrom.text.toString().toDouble() * rate

              //  tvResult.setText("O valor convertido é de: ")
             return  tvResult.setText("O valor convertido é de: " + conversion)
            //    val resultadoIntent = Intent(this@MainActivity, resultado::class.java)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("Não foi")
            }

        })
    }

    fun getCurrencies(){
        val retrofitClient = NetworkUtil.getRetrofitInstance("https://cdn.jsdelivr.net/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getCurrencies().enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }

                val posBRL = data.indexOf("brl")
                val posUSD = data.indexOf("usd")

                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, data)
                spFrom.adapter = adapter
                spTo.adapter = adapter


                spFrom.setSelection(posBRL)
                spTo.setSelection(posUSD)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("Não foi")
            }

        })
    }


}
