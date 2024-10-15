package com.zhahira.detail_movie_buah

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhahira.detail_movie_buah.Adapter.MovieAdapter
import com.zhahira.detail_movie_buah.model.ModelMovie

class  RecycleCardMovie : AppCompatActivity() {
    private var recycleview: RecyclerView? = null
    private var movieAdapter: MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovie>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_card_movie)

        movieList = ArrayList()
        recycleview = findViewById(R.id.rv_movie) as RecyclerView
        movieAdapter = MovieAdapter(this, movieList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recycleview!!.layoutManager = layoutManager
        recycleview!!.adapter = movieAdapter

        prepareMovieList(
        )


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList() {
        var movie = ModelMovie(
            "Avatar",
            R.drawable.avatar,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)

        movie = ModelMovie(
            "Batman",
            R.drawable.batman,
            "29 September 2024",
            getString(R.string.sinopsis4)
        )
        movieList.add(movie)
        movie = ModelMovie(
            "End Game",
            R.drawable.end_game,
            "30 September 2024",
            getString(R.string.sinopsis2)
        )
        movieList.add(movie)
        movie =
            ModelMovie("Hulk", R.drawable.hulk, "29 September 2024", getString(R.string.sinopsis3))
        movieList.add(movie)
        movie = ModelMovie(
            "Inception",
            R.drawable.inception,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)
        movie = ModelMovie(
            "Jumanji",
            R.drawable.jumanji,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)
        movie =
            ModelMovie("Lucy", R.drawable.lucy, "29 September 2024", getString(R.string.sinopsis1))
        movieList.add(movie)
        movie = ModelMovie(
            "Jurassic World",
            R.drawable.jurassic_world,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)
        movie = ModelMovie(
            "Spider Man",
            R.drawable.spider_man,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)
        movie = ModelMovie(
            "Venom",
            R.drawable.venom,
            "29 September 2024",
            getString(R.string.sinopsis1)
        )
        movieList.add(movie)

        movieAdapter!!.notifyDataSetChanged()


    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        intent.putExtra("imageResId", movieList[position].image)
        startActivity(intent)
    }
}