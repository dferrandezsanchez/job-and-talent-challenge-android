package dev.ferrandezdaniel.data.core.restaurants

import org.junit.Test

class RestaurantsServiceFactoryTest {

    companion object {
        const val FAKE_URL = "https://FAKE_URL"
        const val FAKE_TIMEOUT = 10L
    }

    @Test
    fun `On invoke getRestaurantsService from RestaurantsServiceFactory with IRestaurantsApi class and debug should return IRestaurantsApi service`() {
        val restaurantsServiceFactory = RestaurantsServiceFactory(
            debug = true,
            FAKE_URL,
            FAKE_TIMEOUT
        )
        val service = restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java)
        assert(service is IRestaurantsApi)
    }

    @Test
    fun `On invoke getRestaurantsService from RestaurantsServiceFactory with IRestaurantsApi class and not debug should return IRestaurantsApi service`() {
        val restaurantsServiceFactory = RestaurantsServiceFactory(
            debug = false,
            FAKE_URL,
            FAKE_TIMEOUT
        )
        val service = restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java)
        assert(service is IRestaurantsApi)
    }
}
