package com.example.milestone3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley




class MainActivity : AppCompatActivity() {

    var queue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this)
    }

    fun btn(view: View)

    {
        val textView = findViewById<TextView>(R.id.text)
        val url = "https://zv-rest-server.herokuapp.com/users"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response -> // Display the first 500 characters of the response string.
                textView.text = "$response"
            }) { textView.text = "That didn't work!" }

// Add the request to the RequestQueue.
        queue!!.add(stringRequest)
    }
}