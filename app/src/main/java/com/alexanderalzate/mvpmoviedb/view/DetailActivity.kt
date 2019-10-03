package com.alexanderalzate.mvpmoviedb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexanderalzate.mvpmoviedb.R
import com.alexanderalzate.mvpmoviedb.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent?.getSerializableExtra("movie") as Result

        updateUI(movie)

    }

    private fun updateUI(movie: Result) {
        var url_image = "https://image.tmdb.org/t/p/w500"
        tv_title.text = movie.title
        tv_releaseDate.text = movie.releaseDate
        tv_overview.text = movie.overview.toString()
        Picasso.get().load(url_image+movie.posterPath).into(iv_picture)
    }
}
