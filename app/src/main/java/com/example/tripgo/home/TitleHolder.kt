package com.example.tripgo.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun TitleHolder(itemData: Any?) {
    if (itemData == null) {
        return
    }
    ConstraintLayout(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
        val (titleText, seeAllText) = createRefs()
        Text(text = "Recommended", modifier = Modifier.constrainAs(titleText) {
            top.linkTo(parent.top)
            start.linkTo(parent.start, 16.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(seeAllText.start,8.dp)
            width = Dimension.fillToConstraints
        })

        Text(text = "See All", modifier = Modifier.constrainAs(seeAllText) {
            top.linkTo(parent.top)
            end.linkTo(parent.end, 16.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            width=Dimension.wrapContent
        })
    }
}