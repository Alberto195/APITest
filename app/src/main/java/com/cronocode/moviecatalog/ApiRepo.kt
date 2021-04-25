package com.cronocode.moviecatalog

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.cronocode.moviecatalog.models.MovieResponse
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import com.cronocode.moviecatalog.services.MovieApiInterface
import com.cronocode.moviecatalog.services.MovieApiService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class ApiRepo {
    private var instance: ApiRepo? = null
    private val dataSet : ArrayList<OverviewModel?> = ArrayList()

    fun getInstance(): ApiRepo? {
        if(instance==null){
            instance = ApiRepo()
        }
        return instance
    }

    fun getApiRepo(): MutableLiveData<List<OverviewModel?>> {
        setApiRepo()
        val data : MutableLiveData<List<OverviewModel?>> = MutableLiveData()
        data.postValue(dataSet)
        return data
    }

    private fun setApiRepo(){
        dataSet.clear()
        getMovieData()
        getMovieData()
    }

    private fun getMovieData() {
        runBlocking {
            val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
            apiService.getMovie(id = generateRandomId()).enqueue(object : Callback<OverviewModel> {
                override fun onFailure(call: Call<OverviewModel>, t: Throwable) {
                    Log.d("RESPONSE ${Thread.currentThread().name}", "NO")
                }

                override fun onResponse(call: Call<OverviewModel>, response: Response<OverviewModel>) {
                    Log.d("RESPONSE ${Thread.currentThread().name}", response.body().toString())
                    dataSet.add(response.body())
                }
            })
        }
    }

    private fun generateRandomId(): String {
        return "tt0" + Random.nextInt(100000, 999999).toString()
    }
}