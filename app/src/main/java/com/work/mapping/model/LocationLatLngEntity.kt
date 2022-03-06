package com.work.mapping.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LocationLatLngEntity(
    val latitude: Float,
    val longitude: Float
): Parcelable
