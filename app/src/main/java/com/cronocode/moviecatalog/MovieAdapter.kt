package com.cronocode.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies: OverviewModel?
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: OverviewModel){
            itemView.movie_title.text = movie.id
            itemView.movie_release_date.text = movie.releaseDate.toString()
            Glide.with(itemView).load(movie.title.image.url).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return movies.let {
            if (it != null) {
                holder.bindMovie(it)
            }
        }
    }
}