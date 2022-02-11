package dev.ferrandezdaniel.data.core.restaurants

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant

@JsonClass(generateAdapter = true)
data class RestaurantDto(
    val id: Int,
    val uid: String,
    val name: String,
    val type: String,
    val description: String,
    val review: String,
    val logo: String,
    @Json(name = "phone_number")
    val phoneNumber: String,
    val address: String,
    val hours: HoursDto,
)

fun RestaurantDto.transform() = Restaurant(
    id,
    uid,
    name,
    type,
    description,
    review,
    logo,
    phoneNumber,
    address,
    hours.transform()
)
