package com.zhahira.detail_movie_buah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnlist: Button
    private lateinit var btnMovie: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnrv = findViewById<Button>(R.id.btnrv)
        val btnbuah = findViewById<Button>(R.id.btnbuah)

        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)
        btnlist = findViewById(R.id.btnList)
        btnMovie = findViewById(R.id.btnMovie)

        btnLogin.setOnClickListener() {
            val intent = Intent(this, Welcome::class.java)
            val nUsername = etUser.text.toString()
            val password = etPass.text.toString()

            intent.putExtra("username", nUsername)
            intent.putExtra("password", password)
            Log.d("username : ", nUsername)
            Log.d("password : ", password)

            startActivity(intent)
        }

        btnlist.setOnClickListener {
            val intent = Intent(this,com.zhahira.detail_movie_buah.ListView::class.java)
            startActivity(intent)
        }

        btnrv.setOnClickListener {
            val Intent = Intent(this@MainActivity, RecycleViewActivity::class.java)
            startActivity(Intent)
        }
        btnbuah.setOnClickListener {
            val Intent = Intent(this@MainActivity, CustomeImage::class.java)
            startActivity(Intent)
        }

        btnMovie.setOnClickListener {
            val Intent = Intent(this@MainActivity, RecycleCardMovie::class.java)
            startActivity(Intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}