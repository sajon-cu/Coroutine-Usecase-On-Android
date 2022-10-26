package com.lukaslechner.coroutineusecasesonandroid.usecases.flow.mock

import com.lukaslechner.coroutineusecasesonandroid.utils.MockNetworkInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FlowMockApi {

    @GET("current-bitcoin-price")
    suspend fun getCurrentBitcoinPrice(): BitcoinPrice

    @GET("current-etherium-price")
    suspend fun getCurrentEtheriumPrice(): EtheriumPrice
}

fun createFlowMockApi(interceptor: MockNetworkInterceptor): FlowMockApi {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(FlowMockApi::class.java)
}