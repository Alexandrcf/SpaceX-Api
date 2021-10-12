package com.app.spacex.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        private var retrofit: Retrofit? = null

        fun getRetrofitClient(baseURL: String?): Retrofit? {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            val spaceXApi: SpaceXApi? = retrofit?.create(
                SpaceXApi::class.java)
            return retrofit
        }
    }

}