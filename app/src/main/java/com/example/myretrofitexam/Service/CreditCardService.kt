package com.example.myretrofitexam.Service

import com.example.myretrofitexam.Model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("4")
    suspend fun getCreditCards(): List<CreditCard>
}