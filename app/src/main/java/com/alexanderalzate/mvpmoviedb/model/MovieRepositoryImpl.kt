package com.alexanderalzate.mvpmoviedb.model

import com.alexanderalzate.mvpmoviedb.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepositoryImpl(var moviePresenter: MoviePresenter):MovieRepository {
    override fun loadListMovies() {
        val api_key = "af6f5129d8fed1c948777ae5e4ce3974"
        ApiService.create()
            .getTopRated(api_key)
            .enqueue(object : Callback<Movies>{
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    moviePresenter.showErrorLoadMovie(t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if(response.isSuccessful){
                        moviePresenter.sendListMovies(response.body()?.results)
                    }
                }
            })
    }

}