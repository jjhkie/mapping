package com.work.mapping.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class searchResultEntity(
    val fullAdress: String,
    val name: String,
    val locationLatLng: LocationLatLngEntity
): Parcelable