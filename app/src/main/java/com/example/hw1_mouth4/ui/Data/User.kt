package com.example.hw1_mouth4.ui.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name : String="",
    val email : String="",
    val password : String = "",
) : Parcelable
