package com.example.tripgo.home


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.example.tripgo.ui.theme.fontMedium
import com.example.tripgo.ui.theme.fontRegular
import com.example.tripgo.ui.theme.primaryButtonColor

@Composable
fun RecommendedItems(itemData: Any) {
    var clicked = remember {
        false
    }
    if (clicked) {
        showToast()
    }
    ConstraintLayout(modifier = Modifier
        .fillMaxHeight()
        .clickable {
            clicked = true
        }
        .width(150.dp)
        .padding(0.dp)
        .padding(8.dp)) {
        val (itemImage, itemTitle, itemPrice, amountInGram) = createRefs()
        val imageUrl = "https://i.picsum.photos/id/335/200/300.jpg?hmac=G81PbTg8uAk00mCq0eZdiTJwpa_-_FvFZJVhEGcouXQ"
        Image(
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = "Andy Rubin",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .constrainAs(itemImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.end, 16.dp)
                    bottom.linkTo(itemTitle.top, 8.dp)
                }
        )


        Text(text = "Title", modifier = Modifier.constrainAs(itemTitle) {
            top.linkTo(itemImage.bottom)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints

        }, color = Color.Black, fontFamily = FontFamily(fontRegular))

        Text(text = "$ 20", modifier = Modifier.constrainAs(itemPrice) {
            top.linkTo(itemTitle.bottom)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(amountInGram.start, 16.dp)
        }, color = primaryButtonColor, fontFamily = FontFamily(fontMedium))

        Text(text = "1 KG".uppercase(), modifier = Modifier.constrainAs(amountInGram) {
            start.linkTo(itemPrice.end)
            end.linkTo(parent.end, 16.dp)
            top.linkTo(itemTitle.bottom)
            width = Dimension.fillToConstraints
        }, color = primaryButtonColor, fontFamily = FontFamily(fontRegular))

    }
}

@Composable
private fun showToast() {
    Toast
        .makeText(LocalContext.current, "Clicked", Toast.LENGTH_SHORT)
        .show()
}
//@Preview
//@Composable
//fun preview() {
//    RecommendedItems("")
//}