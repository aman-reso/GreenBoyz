package com.example.tripgo.adapters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tripgo.data.PrimaryDataModel
import com.example.tripgo.home.RecommendedItems
import com.example.tripgo.home.TitleHolder
import com.example.tripgo.ui.theme.lineSeparatorColor

private val listModifier = Modifier
    .fillMaxSize()
    .padding(10.dp)

@Composable
fun HomeMainAdapter(homeItems: List<PrimaryDataModel>) {
    val homeItemList = remember {
        homeItems
    }
    LazyColumn(listModifier) {
        items(homeItemList) { homeData ->
            if (homeData.type == 1) {
                GenericLazyRow(homeData.homePageDataResponse)
                Divider(
                    color = (lineSeparatorColor)
                )
            } else if (homeData.type == 2) {
                TitleHolder("")
            }
        }
    }
}

@Composable
private fun GenericLazyRow(sectionList: Any?) {
    if (sectionList == null) {
        return
    }
    val list = remember {
        sectionList
    }
    LazyRow() {
        if (list is ArrayList<*>?) {
            items(list) {
                RecommendedItems(itemData = it)
            }
        }

    }
}