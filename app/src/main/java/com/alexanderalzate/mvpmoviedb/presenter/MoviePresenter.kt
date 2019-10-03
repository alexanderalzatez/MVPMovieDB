package com.alexanderalzate.mvpmoviedb.presenter

import com.alexanderalzate.mvpmoviedb.model.Result

interface MoviePresenter {
    fun loadListMovies()
    fun showErrorLoadMovie(message: String?)
    fun sendListMovies(results: List<Result>?)
}