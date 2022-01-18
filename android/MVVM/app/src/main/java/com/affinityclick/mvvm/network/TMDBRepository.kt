package com.affinityclick.mvvm.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.affinityclick.mvvm.BuildConfig
import com.affinityclick.mvvm.network.models.Movie
import com.affinityclick.mvvm.network.models.PageResult
import com.affinityclick.mvvm.util.CoroutineDispatchersProvider
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Repository responsible for making all web calls to the movie database.
 */
class TMDBRepository @Inject constructor(
  private val coroutineDispatcher: CoroutineDispatchersProvider,
  private val tmdbApi: TMDBApi
) {
  /**
   * @param page Page of top rated movies to show.
   * @return Value to be observed on to return the result
   */
  fun getTopRatedMovies(page: Int): LiveData<FetchResource<PageResult<Movie?>>> = liveData {
    emit(FetchResource.Loading)
    emit(apiCall(call = {tmdbApi.getTopRatedMovies(page, BuildConfig.TMDB_API_KEY)}))
  }

  /**
   *
   * @param id Movie id to lookup
   * @return A live data to be observed on for the results of the call to get the movie
   */
  fun getMovie(id: Int): LiveData<FetchResource<Movie>> = liveData {
    emit(FetchResource.Loading)
    emit(apiCall(call = {tmdbApi.getMovie(id, BuildConfig.TMDB_API_KEY)}))
  }

  /**
   * This method wraps api calls to provide some generic handling and converts the response to a
   * FetchResource wrapper
   *
   * @Param call A suspendable api call that is invoked and wrapped in some generic error handling
   *
   * @return A wrapper around the calls return saying whether it was a Success or Error
   */
  private suspend fun <T : Any> apiCall(call: suspend  () -> Response<T>): FetchResource<T> {
    try {
      val response = call.invoke()
      if (response.isSuccessful) {
        response.body()?.let {
          return FetchResource.Success(it)
        }
      }
    } catch (e: IOException) {
      e.printStackTrace()
    }
    //TODO: return some error context
    return FetchResource.Error
  }
}