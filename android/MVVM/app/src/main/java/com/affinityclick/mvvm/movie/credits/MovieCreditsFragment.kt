package com.affinityclick.mvvm.movie.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider.Factory
import com.affinityclick.mvvm.R.layout
import javax.inject.Inject
import com.affinityclick.mvvm.movie.credits.MovieCreditsViewModel

class MovieCreditsFragment : Fragment() {
  //TODO: create this class
  @JvmField @Inject
  var viewModelFactory: Factory? = null
  private val viewModel: MovieCreditsViewModel? = null
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(layout.credits_fragment, container, false)
  }
}