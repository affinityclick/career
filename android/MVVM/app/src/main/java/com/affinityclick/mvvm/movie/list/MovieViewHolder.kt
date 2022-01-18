package com.affinityclick.mvvm.movie.list

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.affinityclick.mvvm.R
import com.affinityclick.mvvm.R.color
import com.affinityclick.mvvm.databinding.MovieCardBinding
import com.affinityclick.mvvm.network.models.Movie
import com.affinityclick.mvvm.util.MovieUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieViewHolder(private val itemBinding: MovieCardBinding) : ViewHolder(
  itemBinding.root
) {

  fun bind(movie: Movie, movieClickListener: (Movie) -> Unit) {
    if (movie.posterPath != null) {
      Glide
        .with(itemBinding.root)
        .load(MovieUtil.imagePathBuilder(movie.posterPath!!))
        .centerCrop()
        .apply(RequestOptions.placeholderOf(color.colorLoading))
        .into(itemBinding.moviePoster)
    } else {
      Glide
        .with(itemBinding.root)
        .load(R.drawable.ic_menu_gallery)
        .into(itemBinding.moviePoster)
    }

    itemBinding.movieReleaseDate.text = movie.releaseDate?.split("-")!!.toTypedArray()[0]
    itemBinding.movieTitle.text = movie.title
    itemBinding.movieRating.text = movie.voteAverage.toString()
    itemBinding.root.setOnClickListener { movieClickListener(movie) }
  }
}