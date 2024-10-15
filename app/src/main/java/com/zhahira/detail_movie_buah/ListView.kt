package com.zhahira.detail_movie_buah

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ListView : AppCompatActivity() {

    private lateinit var  lv_item :ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        lv_item = findViewById(R.id.lv_hewan)

        //listview
        //listview widget --> Adapter --> Data Source (Array List)

        //array list

        val namahewan = listOf("Gajah","Ular","Beruang","panda","ikan","sapi","kambing" )
        lv_item.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namahewan)

        //bisa diklik
        lv_item.setOnItemClickListener{
                parent,view, position, id ->
            Toast.makeText(this, "Anda Memilih : ${namahewan[position ]}",
                Toast.LENGTH_SHORT).show()

        }

    }
}