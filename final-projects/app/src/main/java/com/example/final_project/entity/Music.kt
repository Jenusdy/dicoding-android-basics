package com.example.final_project.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    val judul: String,
    val deskripsi: String,
    val sampul: Int
) : Parcelable
