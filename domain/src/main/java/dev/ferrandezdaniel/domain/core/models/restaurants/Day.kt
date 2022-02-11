package dev.ferrandezdaniel.domain.core.models.restaurants

data class Day(
    val opensAt: String,
    val closesAt: String,
    val isClosed: Boolean
)
