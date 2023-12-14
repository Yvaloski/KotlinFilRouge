package com.example.myapp_filrouge.utils

import androidx.lifecycle.MutableLiveData
import com.example.myapp_filrouge.bo.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    companion object{
        val BASE_URL = "https://fakestoreapi.com/"

        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }
    @GET("products")
    suspend fun getProducts():List<Article>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id:Int):Article
    object ProductApi{
        val retrofitService: ProductService by lazy { retrofit.create(ProductService::class.java) }
    }

}