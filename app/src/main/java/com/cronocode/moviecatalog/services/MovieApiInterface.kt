package com.cronocode.moviecatalog.services

import com.cronocode.moviecatalog.models.MovieResponse
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {
    @GET("title/get-overview-details?currentCountry=US")
    fun getMovie(@Query("tconst") id: String
    ): Call<OverviewModel>
}
