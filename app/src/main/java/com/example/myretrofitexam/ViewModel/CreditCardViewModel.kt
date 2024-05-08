package com.example.myretrofitexam.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitexam.Model.CreditCard
import com.example.myretrofitexam.Service.CreditCardService
import com.example.myretrofitexam.Service.RetrofitInstance
import kotlinx.coroutines.launch

class CreditCardViewModel: ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<List<CreditCard>>()

    val creditCard: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val list = repository.getCreditCards()
                _creditCards.value = list
            } catch (e:Exception) {
                Log.e("Retrofit Error",e.toString())
                e.printStackTrace()
            }
        }
    }
}