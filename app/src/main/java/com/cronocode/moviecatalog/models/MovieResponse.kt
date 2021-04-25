package com.cronocode.moviecatalog.models

import android.os.Parcelable
import com.cronocode.moviecatalog.models.OverviewMode.Certificates
import com.cronocode.moviecatalog.models.OverviewMode.OverviewModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(
    val movies : OverviewModel

)