package com.alexanderalzate.mvpmoviedb.presenter


import com.alexanderalzate.mvpmoviedb.model.MovieInteractor
import com.alexanderalzate.mvpmoviedb.model.MovieInteractorImpl
import com.alexanderalzate.mvpmoviedb.model.Result
import com.alexanderalzate.mvpmoviedb.view.MovieView

class MoviePresenterImpl(var movieview:MovieView): MoviePresenter {

    private var movieInteractor : MovieInteractor = MovieInteractorImpl(this)

    override fun loadListMovies() {
        movieInteractor.loadListMovies()
    }

    override fun showErrorLoadMovie(message: String?) {
        movieview.showErrorLoadMovies(message)
    }

    override fun sendListMovies(results: List<Result>?) {
        movieview.showListMovies(results)
    }
}