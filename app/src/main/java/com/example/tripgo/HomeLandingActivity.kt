package com.example.tripgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import com.example.tripgo.adapters.HomeMainAdapter
import com.example.tripgo.data.PrimaryDataModel
import com.example.tripgo.data.Recommended
import com.example.tripgo.data.Title
import com.example.tripgo.home.navigation.MainScreen
import com.example.tripgo.home.navigation.Navigation
import com.example.tripgo.network.ResultWrapper
import com.example.tripgo.ui.theme.TripGoTheme
import com.example.tripgo.utility.ShowToast
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity(), ShowToast {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripGoTheme {
                MainScreen()
            }
        }
    }

}

object PrepareData {
    fun getData(): ArrayList<PrimaryDataModel> {
        val list = ArrayList<PrimaryDataModel>()
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 1))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 2))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 3))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 4))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 5))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 6))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 7))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 8))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 9))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 10))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 11))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 12))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 13))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 14))
        list.add(PrimaryDataModel(2, homePageDataResponse = Title("Recommended", "See All"), id = 15))
        list.add(PrimaryDataModel(1, homePageDataResponse = innerData(), id = 16))
        return list
    }

    private fun innerData(): ArrayList<Recommended> {
        val list = ArrayList<Recommended>()
        list.add(Recommended("", "", "", "", "", ""))
        list.add(Recommended("", "", "", "", "", ""))
        list.add(Recommended("", "", "", "", "", ""))
        list.add(Recommended("", "", "", "", "", ""))
        list.add(Recommended("", "", "", "", "", ""))
        list.add(Recommended("", "", "", "", "", ""))
        return list
    }
    
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TripGoTheme {
        Greeting("Android")
    }
}