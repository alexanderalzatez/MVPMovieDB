package com.alexanderalzate.mvpmoviedb.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.alexanderalzate.mvpmoviedb.R
import com.alexanderalzate.mvpmoviedb.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesAdapter(movieList:ArrayList<Result>):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var movieList = ArrayList<Result>()
    init {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val  movie = movieList[position]
        holder.setMovie(movie)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var movie:Result?=null

        init {
            itemView.setOnClickListener(this)
        }

        fun setMovie(movie: Result) {

            this.movie = movie
            var url_image = "https://image.tmdb.org/t/p/w500"
            itemView.tv_title.text = movie.title
            itemView.tv_releaseDate.text = movie.releaseDate
            itemView.tv_voteAverage.text = movie.voteAverage.toString()
            Picasso.get().load(url_image+movie.posterPath).into(itemView.iv_picture)

        }

        override fun onClick(p0: View?) {
            val intent =Intent(itemView.context,DetailActivity::class.java)
            intent.putExtra("movie",movie)
            itemView.context.startActivity(intent)
        }

    }
}