package com.affinityclick.mvvm.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.affinityclick.mvvm.databinding.MovieCardBinding
import com.affinityclick.mvvm.network.models.Movie
import java.util.ArrayList
import kotlin.jvm.Synchronized

class MovieAdapter(private val movieClickListener: (Movie) -> Unit): Adapter<MovieViewHolder>() {
  private val movieList: MutableList<Movie> = ArrayList()

  @Synchronized fun updateMovieList(movies: List<Movie>) {
    movieList.clear()
    movieList.addAll(movies)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
    val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MovieViewHolder(binding)
  }

  override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    val movie = movieList[position]
    holder.bind(movie, movieClickListener)
  }

  override fun getItemCount(): Int {
    return movieList.size
  }

  override fun onViewRecycled(holder: MovieViewHolder) {
    super.onViewRecycled(holder)
  }
}