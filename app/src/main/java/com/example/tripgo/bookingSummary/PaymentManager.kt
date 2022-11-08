package com.example.tripgo.bookingSummary

import com.example.tripgo.MyApplication
import com.razorpay.Checkout
import com.razorpay.PayloadHelper
import com.razorpay.PaymentResultListener
import org.json.JSONObject

interface PaymentCustomCallback {
    fun didPaymentCompleted(message: Any, responseCode: Int)
    fun didPaymentFailed(message: Any, responseCode: Int)
}

class PaymentManager(val paymentCustomCallback: PaymentCustomCallback):PaymentResultListener {

    private var checkout: Checkout? = null

    private fun initializePayments() {
        Checkout.preload(MyApplication.getApplication());
        if (checkout == null) {
            checkout = Checkout()
        }
        checkout?.setKeyID("<YOUR_KEY_ID>");
    }
    private fun setUpAttributes(){
        val payloadHelper = PayloadHelper("INR", 100, "order_XXXXXXXXX")
        payloadHelper.name = "Gaurav Kumar"
        payloadHelper.description = "Description"
        payloadHelper.prefillEmail = "gaurav.kumar@example.com"
        payloadHelper.prefillContact = "9999999999"
        payloadHelper.prefillCardNum = "4111111111111111"
        payloadHelper.prefillCardCvv = "111"
        payloadHelper.prefillCardExp = "11/24"
        payloadHelper.prefillMethod = "netbanking"
        payloadHelper.prefillName = "MerchantName"
        payloadHelper.sendSmsHash = true
        payloadHelper.retryMaxCount = 4
        payloadHelper.retryEnabled = true
        payloadHelper.color = "#000000"
        payloadHelper.allowRotation = true
        payloadHelper.rememberCustomer = true
        payloadHelper.timeout = 10
        payloadHelper.redirect = true
        payloadHelper.recurring = "1"
        payloadHelper.subscriptionCardChange = true
        payloadHelper.customerId = "cust_XXXXXXXXXX"
        payloadHelper.callbackUrl = "https://accepts-posts.request"
        payloadHelper.subscriptionId = "sub_XXXXXXXXXX"
        payloadHelper.modalConfirmClose = true
        payloadHelper.backDropColor = "#ffffff"
        payloadHelper.hideTopBar = true
        payloadHelper.notes = JSONObject("{\"remarks\":\"Discount to cusomter\"}")
        payloadHelper.readOnlyEmail = true
        payloadHelper.readOnlyContact = true
        payloadHelper.readOnlyName = true
        payloadHelper.image = "https://www.razorpay.com"

        payloadHelper.amount=100
        payloadHelper.currency="INR"
        payloadHelper.orderId = "order_XXXXXXXXXXXXXX"
    }

    override fun onPaymentSuccess(p0: String?) {

    }

    override fun onPaymentError(p0: Int, p1: String?) {

    }



}