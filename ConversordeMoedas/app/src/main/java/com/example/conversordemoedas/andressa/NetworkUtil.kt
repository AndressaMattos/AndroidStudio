package com.example.conversordemoedas.util
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path


    class NetworkUtil {
        companion object {
            fun getRetrofitInstance(path: String) : Retrofit {
                return Retrofit.Builder()
                    .baseUrl(path)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
    }
