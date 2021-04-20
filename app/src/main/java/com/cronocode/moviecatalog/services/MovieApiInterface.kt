package com.cronocode.moviecatalog.services

import com.cronocode.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("title/get-overview-details?tconst=tt0944947&currentCountry=US")
    fun getMovieList(): Call<MovieResponse>
}