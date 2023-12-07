package com.example.simpleui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val name:String,
    val photo:Int
) : Parcelable
