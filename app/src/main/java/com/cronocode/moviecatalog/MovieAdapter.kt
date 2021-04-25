package com.cronocode.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies: List<OverviewModel?>?,
    private val listener: MovieViewHolder.Listener

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View, private val listener : Listener) : RecyclerView.ViewHolder(view){

        interface Listener{
            fun onMovieClicked(position: Int)
        }

        fun bindMovie(movie: OverviewModel?){
            itemView.movie_title.text = movie?.title?.title
            itemView.movie_release_date.text = movie?.releaseDate
            if(movie?.title?.image != null) {
                Glide.with(itemView).load(movie.title.image.url).into(itemView.movie_poster)
            }

            itemView.setOnClickListener {
                listener.onMovieClicked(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false),
                listener
        )
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return holder.bindMovie(movies?.get(position))
        }
    }
