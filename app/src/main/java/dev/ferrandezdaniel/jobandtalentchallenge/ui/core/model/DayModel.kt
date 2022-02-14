package dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model

import android.os.Parcelable
import dev.ferrandezdaniel.domain.core.models.restaurants.Day
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayModel(
    val opensAt: String,
    val closesAt: String,
    val isClosed: Boolean
) : Parcelable

fun Day.transform() = DayModel(
    opensAt,
    closesAt,
    isClosed
)
