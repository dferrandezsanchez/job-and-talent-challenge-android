package dev.ferrandezdaniel.data.features.restaurants

import dev.ferrandezdaniel.data.core.restaurants.IRestaurantsApi
import dev.ferrandezdaniel.data.core.restaurants.RestaurantDto
import dev.ferrandezdaniel.data.core.restaurants.RestaurantsServiceFactory
import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response as RetrofitResponse

class RestaurantsDataSourceTest {

    private val restaurantsApi = mockkClass(IRestaurantsApi::class, relaxed = true)
    private val restaurantsServiceFactory = mockkClass(RestaurantsServiceFactory::class)
    private val restaurantsDataSource = RestaurantsDataSource(restaurantsServiceFactory)
    private val mockedRestaurant = mockk<RestaurantDto>(relaxed = true)

    @Test
    fun `On invoke getRestaurants from RestaurantsDataSource should return a Response Success with list of Restaurant`() {
        coEvery { restaurantsApi.getRestaurants() } returns RetrofitResponse.success(listOf(mockedRestaurant))
        coEvery { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) } returns restaurantsApi
        val result: Response<List<Restaurant>> =
            runBlocking { restaurantsDataSource.getRestaurants() }
        coVerify { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) }
        assert(result is Response.Success)
        assert((result as Response.Success).value.isNotEmpty())
    }

    @Test
    fun `On invoke getRestaurants from RestaurantsDataSource should return a Response Success with empty of Restaurant`() {
        coEvery { restaurantsApi.getRestaurants() } returns RetrofitResponse.success(emptyList())
        coEvery { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) } returns restaurantsApi
        val result: Response<List<Restaurant>> =
            runBlocking { restaurantsDataSource.getRestaurants() }
        coVerify { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) }
        assert(result is Response.Success)
        assert((result as Response.Success).value.isEmpty())
    }

    @Test
    fun `On invoke getRestaurants from RestaurantsDataSource should return a Response Failure with an Exception`() {
        coEvery { restaurantsApi.getRestaurants() } throws Exception()
        coEvery { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) } returns restaurantsApi
        val result: Response<List<Restaurant>> =
            runBlocking { restaurantsDataSource.getRestaurants() }
        coVerify { restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java) }
        assert(result is Response.Failure)
        assert((result as Response.Failure).exception is Exception)
    }
}
