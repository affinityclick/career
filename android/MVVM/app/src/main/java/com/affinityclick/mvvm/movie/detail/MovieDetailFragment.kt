package com.affinityclick.mvvm.movie.detail

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.affinityclick.mvvm.R
import com.affinityclick.mvvm.R.color
import com.affinityclick.mvvm.R.string
import com.affinityclick.mvvm.databinding.MovieDetailFragmentBinding
import com.affinityclick.mvvm.network.FetchResource.Loading
import com.affinityclick.mvvm.network.FetchResource.Error
import com.affinityclick.mvvm.network.FetchResource.Success
import com.affinityclick.mvvm.network.FetchResource.Uninitialized
import com.affinityclick.mvvm.network.models.Movie
import com.affinityclick.mvvm.util.MovieUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

  @JvmField @Inject
  var viewModelFactory: Factory? = null
  private lateinit var viewModel: MovieDetailViewModel
  private var movieId: Int = 0
  private lateinit var movie: Movie

  private var _binding: MovieDetailFragmentBinding? = null

  // This property is only valid between onCreateView and onDestroyView.
  private val binding get() = _binding!!

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProvider(this, viewModelFactory!!)[MovieDetailViewModel::class.java]

    //Retrieve the arguments from the Navigation controller and trigger the load of details
    val args: MovieDetailFragmentArgs by navArgs()
    movie = args.movie
    movieId = args.movie.id!!
    viewModel.getMovieDetail(movieId)

    //Observe on the result
    viewModel.movieLiveData.observe(
      this, {
        when (it) {
          is Error -> Toast.makeText(
            context, string.generic_error, Toast.LENGTH_LONG
          ).show()
          is Loading -> {}
          is Success -> {
            movie = it.value
            refreshUI()
          }
          is Uninitialized -> {}
          else -> {}
        }
      })
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = MovieDetailFragmentBinding.inflate(inflater, container, false)
    binding.movieCredits.setOnClickListener {
      val action = MovieDetailFragmentDirections.viewMovieCredits(
        movieId
      )
      findNavController().navigate(action)
    }

    refreshUI()
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun refreshUI() {
    binding.movieDetailsTitle.text = movie.title
    binding.summaryLabel.visibility = View.VISIBLE
    binding.movieDetailsOverview.text = movie.overview
    binding.movieDetailsRating.visibility = View.VISIBLE
    binding.movieDetailsRating.rating = (movie.voteAverage!! / 2).toFloat()

    movie.genres?.let { genres ->
      val currentGenres: List<String> = genres.mapNotNull { it.name }
      binding.movieDetailsGenres.text = TextUtils.join(", ", currentGenres)
    }
    binding.movieDetailsReleaseDate.text = movie.releaseDate
    if (movie.backdropPath != null) {
      Glide.with(binding.movieDetailsBackdrop)
        .load(MovieUtil.imagePathBuilder(movie.backdropPath!!))
        .apply(RequestOptions.placeholderOf(color.colorLoading))
        .into(binding.movieDetailsBackdrop)
    } else {
      Glide.with(binding.movieDetailsBackdrop)
        .load(R.drawable.ic_menu_gallery)
        .into(binding.movieDetailsBackdrop)
    }

    //TODO: Trailers
    //TODO: Reviews
  }
}