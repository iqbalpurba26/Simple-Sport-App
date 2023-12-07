package com.example.simpleui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal (
    val photo : Int,
    val title : String,
    val kalori : String
) : Parcelable