package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpokenLanguage(
  @SerializedName("iso_639_1") @Expose var iso6391: String?,
  @SerializedName("name") @Expose var name: String?
) : Parcelable