package com.example.simpleui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AddExercise(
    val bgPhoto:Int,
    val photo : Int,
    val title : String,
    val kalori: String,
    val time : String,
    val level : String
) : Parcelable
