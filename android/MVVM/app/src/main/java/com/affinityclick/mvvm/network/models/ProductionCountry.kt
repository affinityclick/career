package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCountry(
  @SerializedName("iso_3166_1") @Expose var iso31661: String?,
  @SerializedName("name") @Expose var name: String?
) : Parcelable