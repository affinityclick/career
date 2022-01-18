package com.affinityclick.mvvm.movie.list.topRated

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.affinityclick.mvvm.R.string
import com.affinityclick.mvvm.databinding.MovieListFragmentBinding
import com.affinityclick.mvvm.movie.list.MovieAdapter
import com.affinityclick.mvvm.network.FetchResource.Error
import com.affinityclick.mvvm.network.FetchResource.Loading
import com.affinityclick.mvvm.network.FetchResource.Success
import com.affinityclick.mvvm.network.FetchResource.Uninitialized

import com.affinityclick.mvvm.network.models.Movie
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieTopRatedListFragment : Fragment() {
  @JvmField @Inject
  var viewModelFactory: Factory? = null
  private var viewModel: MovieTopRatedListViewModel? = null
  private var movieAdapter: MovieAdapter? = null

  private var _binding: MovieListFragmentBinding? = null
  // This property is only valid between onCreateView and onDestroyView.
  private val binding get() = _binding!!

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
    movieAdapter = MovieAdapter { movie: Movie ->
      val action = MovieTopRatedListFragmentDirections.viewMovieDetail(movie)
      findNavController().navigate(action)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProvider(this, viewModelFactory!!)[MovieTopRatedListViewModel::class.java]
    viewModel?.movieListLiveData?.observe(this, {
      when (it) {
        is Error -> {
          Toast.makeText(context, string.generic_error, Toast.LENGTH_LONG).show()
        }
        is Loading -> {}
        is Success -> it.value.results?.let { movies ->
          movieAdapter?.updateMovieList(
            movies.filterNotNull()
          )
        }
        is Uninitialized -> {}
        else -> {}
      }
    })
    viewModel?.getMovieList(1)
    //TODO: Make this an infinite scrollView
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = MovieListFragmentBinding.inflate(inflater, container, false)
    binding.movieList.layoutManager = LinearLayoutManager(context)
    binding.movieList.adapter = movieAdapter
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}