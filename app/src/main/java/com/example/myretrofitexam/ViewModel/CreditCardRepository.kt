package com.example.myretrofitexam.ViewModel

import com.example.myretrofitexam.Model.CreditCard
import com.example.myretrofitexam.Service.CreditCardService
import com.example.myretrofitexam.Service.RetrofitInstance

class CreditCardRepository {
    private val creditCardService: CreditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}