package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
  @SerializedName("id") @Expose var id: Int? = null,
  @SerializedName("name") @Expose var name: String?
) : Parcelable