package com.alexanderalzate.mvpmoviedb.view

import com.alexanderalzate.mvpmoviedb.model.Result

interface MovieView {
    fun showErrorLoadMovies(message: String?)
    fun showListMovies(results: List<Result>?)

}