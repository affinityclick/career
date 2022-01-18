package com.affinityclick.mvvm.network

import com.affinityclick.mvvm.network.models.Movie
import com.affinityclick.mvvm.network.models.PageResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Api that interacts with the movie database
 * @see [The Movie Database](https://developers.themoviedb.org/3/getting-started/introduction)
 */
interface TMDBApi {
  @GET("movie/top_rated") suspend fun getTopRatedMovies(
    @Query("page") page: Int,
    @Query("api_key") userkey: String
  ): Response<PageResult<Movie?>>

  @GET("movie/{id}") suspend fun getMovie(
    @Path("id") id: Int,
    @Query("api_key") userkey: String
  ): Response<Movie>
}