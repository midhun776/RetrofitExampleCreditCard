package com.example.myretrofitexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myretrofitexam.ViewModel.CreditCardViewModel
import com.example.myretrofitexam.ui.theme.MyRetrofitExamTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CreditCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRetrofitExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListCreditCards("Android",viewModel)
                }
            }
        }
    }
}

@Composable
fun ListCreditCards(
    name: String,
    viewModel: CreditCardViewModel,
    modifier: Modifier = Modifier) {

    val creditCards by viewModel.creditCard.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCards.isEmpty()){
            Text(text = "Loading..")
            CircularProgressIndicator()
        } else {
            LazyColumn() {
                items(creditCards) {card ->
                    Text(text = card.name)
                    Text(text = card.card_number)
                    Text(text = card.card_expiry_date)
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}