package dev.ferrandezdaniel.data.core.restaurants

import com.squareup.moshi.JsonClass
import dev.ferrandezdaniel.domain.core.models.restaurants.Hours

@JsonClass(generateAdapter = true)
data class HoursDto(
    val monday: DayDto,
    val tuesday: DayDto,
    val wednesday: DayDto,
    val thursday: DayDto,
    val friday: DayDto,
    val saturday: DayDto,
    val sunday: DayDto
)

fun HoursDto.transform() = Hours(
    monday.transform(),
    tuesday.transform(),
    wednesday.transform(),
    thursday.transform(),
    friday.transform(),
    saturday.transform(),
    sunday.transform()
)
