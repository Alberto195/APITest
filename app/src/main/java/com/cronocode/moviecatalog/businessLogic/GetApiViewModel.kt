package com.cronocode.moviecatalog.businessLogic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cronocode.moviecatalog.ApiRepo
import com.cronocode.moviecatalog.models.MovieResponse
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import kotlinx.coroutines.Dispatchers

class GetApiViewModel(): ViewModel() {

    private var movieList : MutableLiveData<List<OverviewModel?>>? = null
    private var mRepo : ApiRepo? = null

    fun init(){
        if(mRepo!=null){
            return
        }

        mRepo = ApiRepo().getInstance()!!
        movieList = mRepo!!.getApiRepo()
    }

    fun getMovie(): MutableLiveData<List<OverviewModel?>>? {
        return movieList
    }

    fun refreshData(){
        if(mRepo!=null){
            mRepo!!.getApiRepo()
        }
    }
}
