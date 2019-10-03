package com.alexanderalzate.mvpmoviedb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexanderalzate.mvpmoviedb.R
import com.alexanderalzate.mvpmoviedb.model.Result
import com.alexanderalzate.mvpmoviedb.presenter.MoviePresenter
import com.alexanderalzate.mvpmoviedb.presenter.MoviePresenterImpl
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.recyclerview


class MoviesFragment : Fragment(), MovieView {


    private var moviePresenter:MoviePresenter ?= null
    private lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_movies, container, false)

        moviePresenter = MoviePresenterImpl(this)
        getMovies()

        return root
    }
    private fun getMovies(){
        moviePresenter?.loadListMovies()
    }
    override fun showErrorLoadMovies(message: String?) {
        Toast.makeText(activity?.applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    override fun showListMovies(results: List<Result>?) {
        root.recyclerview.layoutManager = LinearLayoutManager(activity?.applicationContext,RecyclerView.VERTICAL,false)

        val movieAdapter = MoviesAdapter(results as ArrayList<Result>)

        root.recyclerview.adapter = movieAdapter
    }
}