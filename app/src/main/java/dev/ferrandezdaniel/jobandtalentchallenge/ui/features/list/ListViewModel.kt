package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ferrandezdaniel.domain.core.result.Response
import dev.ferrandezdaniel.domain.features.restaurants.useCases.GetRestaurantsUseCase
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model.RestaurantModel
import dev.ferrandezdaniel.jobandtalentchallenge.ui.core.model.transform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {

    private val _restaurantsList = MutableLiveData<List<RestaurantModel>>()
    val restaurantsList: LiveData<List<RestaurantModel>> = _restaurantsList

    private val _restaurantsException = MutableLiveData<Throwable>()
    val restaurantsException: LiveData<Throwable> = _restaurantsException

    private val _loadingData = MutableLiveData<Boolean>()
    val loadingData: LiveData<Boolean> = _loadingData

    init {
        viewModelScope.launch {
            _loadingData.postValue(true)
            withContext(Dispatchers.IO) {
                when (val result = getRestaurantsUseCase()) {
                    is Response.Failure -> {
                        _restaurantsException.value = result.exception
                        _loadingData.postValue(false)
                    }
                    is Response.Success -> {
                        _restaurantsList.postValue(
                            result.value.map { it.transform() }
                        )
                        _loadingData.postValue(false)
                    }
                }
            }
        }
    }
}
