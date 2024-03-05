package com.example.my_quote

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_quote.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRandomQuote()

        binding.btnAllQuotes.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListQuotesActivity::class.java))
        }
    }

    private fun getRandomQuote() {
        binding.progressBar.visibility = View.VISIBLE
        var client = AsyncHttpClient()

        var url = "https://quote-api.dicoding.dev/random"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(p0: Int, p1: Array<out Header>?, p2: ByteArray) {

                binding.progressBar.visibility = View.INVISIBLE
                val result = String(p2)

                try {
                    val responseObject = JSONObject(result)
                    val quote = responseObject.getString("en")
                    val author = responseObject.getString("author")
                    binding.tvQuote.text = quote
                    binding.tvAuthor.text = author

                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }

            }

            override fun onFailure(
                p0: Int,
                p1: Array<out Header>?,
                p2: ByteArray?,
                p3: Throwable?
            ) {
                val errorMessage = when (p0) {
                    401 -> "$p0 : Bad Request"
                    403 -> "$p0 : Forbidden"
                    404 -> "$p0 : Not Found"
                    else -> "$p0 : ${p3?.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}