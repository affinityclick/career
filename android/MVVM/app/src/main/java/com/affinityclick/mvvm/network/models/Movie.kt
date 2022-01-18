package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Movie(
  @SerializedName("adult") @Expose var adult: Boolean?,
  @SerializedName("backdrop_path") @Expose var backdropPath: String?,
  @SerializedName("belongs_to_collection") @Expose var belongsToCollection: @RawValue Any? = null,
  @SerializedName("budget") @Expose var budget: Int? = null,
  @SerializedName("genres") @Expose var genres: List<Genre>? = null,
  @SerializedName("genre_ids") @Expose var genreIds: List<Int>? = null,
  @SerializedName("homepage") @Expose var homepage: String?,
  @SerializedName("id") @Expose var id: Int? = null,
  @SerializedName("imdb_id") @Expose var imdbId: String?,
  @SerializedName("original_language") @Expose var originalLanguage: String?,
  @SerializedName("original_title") @Expose var originalTitle: String?,
  @SerializedName("overview") @Expose var overview: String?,
  @SerializedName("popularity") @Expose var popularity: Double? = null,
  @SerializedName("poster_path") @Expose var posterPath: String?,
  @SerializedName("production_companies") @Expose var productionCompanies: List<ProductionCompany>? = null,
  @SerializedName("production_countries") @Expose var productionCountries: List<ProductionCountry>? = null,
  @SerializedName("release_date") @Expose var releaseDate: String?,
  @SerializedName("revenue") @Expose var revenue: Int? = null,
  @SerializedName("runtime") @Expose var runtime: Int? = null,
  @SerializedName("spoken_languages") @Expose var spokenLanguages: List<SpokenLanguage>? = null,
  @SerializedName("status") @Expose var status: String?,
  @SerializedName("tagline") @Expose var tagline: String?,
  @SerializedName("title") @Expose var title: String?,
  @SerializedName("video") @Expose var video: Boolean?,
  @SerializedName("vote_average") @Expose var voteAverage: Double? = null,
  @SerializedName("vote_count") @Expose var voteCount: Int? = null
) : Parcelable
