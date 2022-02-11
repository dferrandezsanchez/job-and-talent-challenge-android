package dev.ferrandezdaniel.domain.features.restaurants.useCases

import dev.ferrandezdaniel.domain.features.restaurants.IRestaurantsRepository

class GetRestaurantsUseCase(
    private val restaurantRepository: IRestaurantsRepository
) {
    suspend operator fun invoke() = restaurantRepository.getRestaurants()
}
