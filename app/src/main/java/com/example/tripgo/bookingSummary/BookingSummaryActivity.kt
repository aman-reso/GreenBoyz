package com.example.tripgo.bookingSummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.Composable
import com.example.tripgo.compose.ComposeAbstraction

class BookingSummaryActivity : AppCompatActivity(), ComposeAbstraction,PaymentCustomCallback{

    private val paymentManager:PaymentManager by lazy { PaymentManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Composable
    override fun CollectAllViews() {

    }

    @Composable
    override fun PreviewAllViews() {
    }

    override fun didPaymentCompleted(message: Any, responseCode: Int) {

    }

    override fun didPaymentFailed(message: Any, responseCode: Int) {

    }
}