package dev.ferrandezdaniel.domain.core.models.restaurants

data class Restaurant(
    val id: Int,
    val uid: String,
    val name: String,
    val type: String,
    val description: String,
    val review: String,
    val logo: String,
    val phoneNumber: String,
    val address: String,
    val hours: Hours
)
