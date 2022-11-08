package com.example.tripgo.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.tripgo.const.ENTER_MOBILE_NUM
import com.example.tripgo.const.INVALID_MOBILE_NUM
import com.example.tripgo.const.MOBILE_NUM_THRESHOLD
import com.example.tripgo.const.REQUEST_OTP
import com.example.tripgo.extensions.getNumberKeyboardOptions
import com.example.tripgo.extensions.showToastMessage
import com.example.tripgo.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginMainContainer(loginViewModel: LoginViewModel) {
    var inputNumber by rememberSaveable { mutableStateOf("") }
    val context: Context = LocalContext.current
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        val (getOtpBtn, mobileNumBtn) = createRefs()
        // mobile number edittext
        TextField(value = inputNumber, onValueChange = {
            if (it.length <= MOBILE_NUM_THRESHOLD) {
                inputNumber = it
            } else {
                INVALID_MOBILE_NUM.showToastMessage(context)
            }
        }, keyboardOptions = getNumberKeyboardOptions(),
            placeholder = { Text(ENTER_MOBILE_NUM) },
            modifier = Modifier
                .padding(vertical = 0.dp)
                .padding(0.dp)
                .constrainAs(mobileNumBtn) {
                    height = Dimension.fillToConstraints
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    bottom.linkTo(getOtpBtn.top, 16.dp)
                },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                disabledLabelColor = Color.Blue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            trailingIcon = {

            })

        //button for requesting otp
        Button(onClick = {
            proceedToGetOtp(inputNumber, context)
        },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .constrainAs(getOtpBtn) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Row(modifier = Modifier.wrapContentHeight()) {
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(text = REQUEST_OTP, textAlign = TextAlign.Center)
        }

    }
}


//function which is used for on clicking on RequestOtp Button
private fun proceedToGetOtp(mobileNumber: String?, context: Context?) {
    if (context == null) {
        return
    }
    if (mobileNumber.isNullOrEmpty()) {
        Toast.makeText(context, INVALID_MOBILE_NUM, Toast.LENGTH_SHORT).show()
    } else {

    }
}

