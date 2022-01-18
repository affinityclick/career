package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Credits(
  @SerializedName("id") @Expose var id: Int? = null,
  @SerializedName("cast") @Expose var cast: List<Cast?>? = null,
  @SerializedName("crew") @Expose var crew: List<Crew?>? = null
) : Parcelable