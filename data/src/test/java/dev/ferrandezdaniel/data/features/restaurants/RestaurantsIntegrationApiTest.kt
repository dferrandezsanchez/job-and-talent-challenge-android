package dev.ferrandezdaniel.data.features.restaurants

import dev.ferrandezdaniel.data.core.restaurants.RestaurantsServiceFactory
import dev.ferrandezdaniel.domain.core.result.Response
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RestaurantsIntegrationApiTest {

    companion object {
        private const val FAKE_DEBUG: Boolean = true
        private const val FAKE_URL: String = "https://random-data-api.com/"
        private const val FAKE_TIMEOUT: Long = 10L
    }

    @Test
    fun `On invoke getPlaces should return list of Places`() {
        val service = RestaurantsServiceFactory(
            FAKE_DEBUG,
            FAKE_URL,
            FAKE_TIMEOUT
        )
        val restaurantsDataSource = RestaurantsDataSource(service)
        val result = runBlocking { restaurantsDataSource.getRestaurants() }
        assert(result is Response.Success)
        assert((result as Response.Success).value.isNotEmpty())
    }
}
