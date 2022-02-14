package dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model

import android.graphics.Bitmap
import android.os.Parcelable
import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.image.getBitmapFromURL
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantModel(
    val id: Int,
    val uid: String,
    val name: String,
    val type: String,
    val description: String,
    val review: String,
    val logo: Bitmap?,
    val phoneNumber: String,
    val address: String,
    val hours: HoursModel
) : Parcelable

fun Restaurant.transform() = RestaurantModel(
    id,
    uid,
    name,
    type,
    description,
    review,
    logo.getBitmapFromURL(),
    phoneNumber,
    address,
    hours.transform()
)
