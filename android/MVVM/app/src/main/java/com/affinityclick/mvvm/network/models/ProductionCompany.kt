package com.affinityclick.mvvm.network.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompany(
  @SerializedName("id") @Expose var id: Int? = null,
  @SerializedName("logo_path") @Expose var logoPath: String?,
  @SerializedName("name") @Expose var name: String?,
  @SerializedName("origin_country") @Expose var originCountry: String?
) : Parcelable