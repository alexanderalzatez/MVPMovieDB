package com.alexanderalzate.mvpmoviedb.model

import com.alexanderalzate.mvpmoviedb.presenter.MoviePresenter

class MovieInteractorImpl(var moviePresenter: MoviePresenter):MovieInteractor {

    private var movieRepository:MovieRepository = MovieRepositoryImpl(moviePresenter)

    override fun loadListMovies() {
        movieRepository.loadListMovies()
    }
}