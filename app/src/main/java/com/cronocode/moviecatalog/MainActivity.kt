package com.cronocode.moviecatalog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cronocode.moviecatalog.businessLogic.GetApiViewModel
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity(), MovieAdapter.MovieViewHolder.Listener {

    private lateinit var viewModel: GetApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(GetApiViewModel::class.java)
        viewModel.init()
        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        rv_movies_list.adapter = MovieAdapter(viewModel.getMovie()?.value, this@MainActivity)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMovie()?.observe(this, Observer<List<OverviewModel?>>{
            rv_movies_list.adapter?.notifyDataSetChanged()
        })
    }

    override fun onMovieClicked(position: Int) {
        val list: List<OverviewModel?>? = viewModel.getMovie()?.value
        if(position==0) {
            if (list?.get(position)?.ratings?.rating!! >= list[position + 1]?.ratings?.rating!!) {
                val text = "Nice! {} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                viewModel.refreshData()

            }
        }
        else if(position==1){
            if (list?.get(position)?.ratings?.rating!! >= list[position-1]?.ratings?.rating!!) {
                val text = "Nice! {} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                viewModel.refreshData()

            }
        }
    }
}
