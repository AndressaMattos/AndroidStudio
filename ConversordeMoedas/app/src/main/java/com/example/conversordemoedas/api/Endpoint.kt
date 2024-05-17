package com.example.conversordemoedas.api

import retrofit2.http.GET
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
import retrofit2.http.Path

interface Endpoint {



    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getCurrencies() : Call<JsonObject>

    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies/{from}/{to}.json")
    fun getCurrencyRate(@Path(value = "from", encoded = true) from : String,
                        @Path(value = "to", encoded = true) to : String)
            : Call<JsonObject>


}