package io.github.jenusdy.musyrik.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    val judul: String,
    val deskripsi: String,
    val youtubeID: String,
    val lirik: String,
    val sampul: Int
) : Parcelable