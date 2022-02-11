package dev.ferrandezdaniel.data.features.restaurants

import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RestaurantsRepositoryTest {

    private val restaurantsDataSource = mockk<RestaurantsDataSource>()
    private val restaurantsRepository = RestaurantsRepository(restaurantsDataSource)

    private val mockedRestaurant = mockk<Restaurant>(relaxed = true)

    @Test
    fun `On invoke getRestaurants from RestaurantsDataSource should return Response Success with list of Restaurants`() {
        coEvery { restaurantsRepository.getRestaurants() } returns Response.Success(listOf(mockedRestaurant))
        val result = runBlocking { restaurantsRepository.getRestaurants() }
        coVerify { restaurantsDataSource.getRestaurants() }
        assert((result as Response.Success).value.isNotEmpty())
    }

    @Test
    fun `On invoke getRestaurants from RestaurantsDataSource should return Response Failure with an Esception`() {
        coEvery { restaurantsRepository.getRestaurants() } returns Response.Failure(Exception())
        val result = runBlocking { restaurantsRepository.getRestaurants() }
        coVerify { restaurantsDataSource.getRestaurants() }
        assert((result as Response.Failure).exception is Exception)
    }
}
