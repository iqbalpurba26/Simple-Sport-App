package com.example.simpleui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise (
    val photo:Int,
    val title:String,
    val time:String
) : Parcelable