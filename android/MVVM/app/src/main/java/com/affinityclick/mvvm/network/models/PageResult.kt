package com.affinityclick.mvvm.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PageResult<T>(
  @SerializedName("page") @Expose var page: Int = 0,
  @SerializedName("total_results") @Expose var totalResults: Int = 0,
  @SerializedName("total_pages") @Expose var totalPages: Int = 0,
  @SerializedName("results") var results: List<T>? = null
)