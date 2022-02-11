package dev.ferrandezdaniel.domain.core.models.restaurants

data class Hours(
    val monday: Day,
    val tuesday: Day,
    val wednesday: Day,
    val thursday: Day,
    val friday: Day,
    val saturday: Day,
    val sunday: Day
)
