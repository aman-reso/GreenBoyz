package com.example.tripgo.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.yogeshpaliyal.speld.PinInput

@Composable
fun OtpVerification() {
    val enteredOtpText = remember { mutableStateOf("") }
    ConstraintLayout(modifier = Modifier
        .fillMaxHeight(100f)
        .fillMaxWidth(100f)) {
         val (verifyOtpBtn,otpEditTextField,otpContainer) = createRefs()

        ConstraintLayout(modifier = Modifier.constrainAs(otpContainer){
            bottom.linkTo(verifyOtpBtn.top,16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }){
            PinInput(
                modifier = Modifier
                    .height(50.dp)
                    .border(BorderStroke(2.dp, Color.Red), shape = RoundedCornerShape(3.dp))
                    .constrainAs(otpEditTextField) {
                        bottom.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                value = enteredOtpText.value,
                length = 4,
                disableKeypad = false,
                obscureText = null
            ) {
                enteredOtpText.value = it
            }

        }
        Button(onClick = {

        }, shape = RoundedCornerShape(8.dp), modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .constrainAs(verifyOtpBtn) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Row(modifier = Modifier.wrapContentHeight()) {
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(text = "Verify OTP", textAlign = TextAlign.Center)
        }
    }
}