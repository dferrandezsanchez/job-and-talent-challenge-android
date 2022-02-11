package dev.ferrandezdaniel.data.core.restaurants

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.ferrandezdaniel.domain.core.models.restaurants.Day

@JsonClass(generateAdapter = true)
data class DayDto(
    @Json(name = "opens_at")
    val opensAt: String,

    @Json(name = "closes_at")
    val closesAt: String,

    @Json(name = "is_closed")
    val isClosed: Boolean
)

fun DayDto.transform() = Day(
    opensAt,
    closesAt,
    isClosed
)
