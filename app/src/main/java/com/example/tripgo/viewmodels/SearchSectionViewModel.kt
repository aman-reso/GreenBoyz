package com.example.tripgo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tripgo.network.ApiRequestManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchSectionViewModel  @Inject constructor(apiRequestManager: ApiRequestManager) : ViewModel() {


}