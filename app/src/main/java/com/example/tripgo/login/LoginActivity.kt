package com.example.tripgo.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.tripgo.compose.ComposeAbstraction
import com.example.tripgo.di.BlogDatabaseModule
import com.example.tripgo.storage.db.UserDao
import com.example.tripgo.ui.theme.TripGoTheme
import com.example.tripgo.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity(), ComposeAbstraction {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripGoTheme {
                Box(modifier = Modifier.fillMaxSize()) {
//                    OtpVerification()
                    LoginMainContainer(loginViewModel)
                }
            }
        }
        loginViewModel.setData()

    }

    @Composable
    override fun CollectAllViews() {

    }

    @Composable
    @Preview
    override fun PreviewAllViews() {

    }
}