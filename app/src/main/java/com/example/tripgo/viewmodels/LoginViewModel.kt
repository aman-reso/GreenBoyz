package com.example.tripgo.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripgo.data.UserModel
import com.example.tripgo.network.ApiRequestManager
import com.example.tripgo.storage.db.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor( apiRequestManager: ApiRequestManager,private var userDao: UserDao) : ViewModel() {
    var inputNumber = MutableLiveData<String>("")

    fun setData() {
        viewModelScope.launch {
            val userModel = UserModel()
            userDao.setUser(userModel)
        }
    }
}