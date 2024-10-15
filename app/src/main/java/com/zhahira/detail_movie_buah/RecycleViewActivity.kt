package com.zhahira.detail_movie_buah

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhahira.detail_movie_buah.Adapter.BukuAdapter
import com.zhahira.detail_movie_buah.R.id.rv_buku
import com.zhahira.detail_movie_buah.model.ModelBuku

class RecycleViewActivity : AppCompatActivity() {

    // view group = menampung lbih cepat lbih byk
    //recycle load = data yang dilayar aja

    private lateinit var rv_buku : RecyclerView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_buku = findViewById(R.id.rv_buku)

        val listBuku = listOf(
            ModelBuku(title = "Buku Android Kotlin 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin2 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin3 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin4 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin5 2024", penulis = "Rizki Syaputra"),
        )

        val nBukuAdapter = BukuAdapter(listBuku)
        rv_buku.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}