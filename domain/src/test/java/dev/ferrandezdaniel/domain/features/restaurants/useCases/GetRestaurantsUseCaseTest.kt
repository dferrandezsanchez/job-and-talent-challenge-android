package dev.ferrandezdaniel.domain.features.restaurants.useCases

import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response
import dev.ferrandezdaniel.domain.features.restaurants.IRestaurantsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetRestaurantsUseCaseTest {

    private val restaurantsRepository = mockk<IRestaurantsRepository>()
    private val getRestaurantsUseCase = GetRestaurantsUseCase(restaurantsRepository)
    private val mockedRestaurant = mockk<Restaurant>(relaxed = true)

    @Test
    fun `On invoke should return Response Success with list of Restaurants`() {
        coEvery { restaurantsRepository.getRestaurants() } returns Response.Success(
            listOf(
                mockedRestaurant
            )
        )
        val result = runBlocking { getRestaurantsUseCase() }
        coVerify { restaurantsRepository.getRestaurants() }
        assert(result is Response.Success)
        assert((result as Response.Success).value.isNotEmpty())
    }

    @Test
    fun `On invoke should return Response Failure with an Esception`() {
        coEvery { restaurantsRepository.getRestaurants() } returns Response.Failure(
            Exception()
        )
        val result = runBlocking { getRestaurantsUseCase() }
        coVerify { restaurantsRepository.getRestaurants() }
        assert(result is Response.Failure)
        assert((result as Response.Failure).exception is Exception)
    }
}
