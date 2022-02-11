package dev.ferrandezdaniel.data.core.restaurants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RestaurantsServiceFactory(
    private val debug: Boolean,
    private val url: String,
    private val timeout: Long,
) {

    fun <T> getRestaurantsService(
        apiClass: Class<T>
    ): T =
        Retrofit.Builder()
            .baseUrl(url)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level =
                                if (debug) HttpLoggingInterceptor.Level.HEADERS
                                else HttpLoggingInterceptor.Level.NONE
                        }
                    )
                    .writeTimeout(timeout, TimeUnit.SECONDS)
                    .readTimeout(timeout, TimeUnit.SECONDS)
                    .build()
            ).addConverterFactory(MoshiConverterFactory.create()).build()
            .create(apiClass)
}
