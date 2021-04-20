package com.cronocode.moviecatalog.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieBase (
    @SerializedName("id")
    val id : String ?,
    val title: String ?,
    val year: String ?

) : Parcelable {
    constructor() : this("", "", "")
}