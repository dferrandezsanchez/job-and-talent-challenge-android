package dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model

import android.os.Parcelable
import dev.ferrandezdaniel.domain.core.models.restaurants.Hours
import kotlinx.parcelize.Parcelize

@Parcelize
data class HoursModel(
    val monday: DayModel,
    val tuesday: DayModel,
    val wednesday: DayModel,
    val thursday: DayModel,
    val friday: DayModel,
    val saturday: DayModel,
    val sunday: DayModel
) : Parcelable

fun Hours.transform() = HoursModel(
    monday.transform(),
    tuesday.transform(),
    wednesday.transform(),
    thursday.transform(),
    friday.transform(),
    saturday.transform(),
    sunday.transform()
)
