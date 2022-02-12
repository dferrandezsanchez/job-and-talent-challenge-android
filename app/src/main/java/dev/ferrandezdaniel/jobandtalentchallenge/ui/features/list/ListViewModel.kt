package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response
import dev.ferrandezdaniel.domain.features.restaurants.useCases.GetRestaurantsUseCase
import kotlinx.coroutines.launch

class ListViewModel(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {

    private val _restaurantsList = MutableLiveData<List<Restaurant>>()
    val restaurantsList: LiveData<List<Restaurant>> = _restaurantsList

    private val _restaurantsException = MutableLiveData<Throwable>()
    val restaurantsException: LiveData<Throwable> = _restaurantsException

    init {
        viewModelScope.launch {
            when (val result = getRestaurantsUseCase()) {
                is Response.Failure -> _restaurantsException.value = result.exception ?: Exception("MEEEEEHHH")
                is Response.Success -> _restaurantsList.value = result.value ?: emptyList()
            }
        }
    }
}
