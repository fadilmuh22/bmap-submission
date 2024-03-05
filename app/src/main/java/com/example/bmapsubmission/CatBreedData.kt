package com.example.bmapsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatBreedData(
    val name: String,
    val temperaments: String,
    val description: String,
    val photo: String,
    val origin: String,
    val vetStreet: String,
    val countryFlag: String,
) : Parcelable
