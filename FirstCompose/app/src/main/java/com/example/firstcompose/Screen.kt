package com.example.firstcompose

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview( heightDp = 500)
@Composable
fun PreviewItem (){
//  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//     getCategoryList().map { item ->
//         BlogCategory(imageId = item.imageId, title = item.title, subtitle = item.subtitle)
//     }
//  }
    // we use lazyColumn instead of normal column // LazyRow use to horizontally render
    // because lazyColumn composable will render only that item which will appear on screen while scrolling

    LazyColumn {
        items(getCategoryList()){item ->
            BlogCategory(imageId = item.imageId, title = item.title, subtitle = item.subtitle)
        }
    }
}

@Composable
fun BlogCategory(imageId:Int, title:String , subtitle:String) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "UserProfile",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f) // 20% of Row will capture by Image
            )
            ItemDescription(title, subtitle,Modifier.Companion.weight(.8f) )
        }
    }
}

@Composable // now this composable is reusable composable
private fun ItemDescription(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) { // 80% or row will capture by column
        Text(
            text = title,
//                    fontWeight = FontWeight.Bold
            style = MaterialTheme.typography.labelLarge
        )

        Text(
            text = subtitle,
            fontWeight = FontWeight.Thin,
//                    fontSize = 12.sp
//                    style = MaterialTheme.typography.titleSmall
        )
    }
}

data class Category (val imageId: Int, val title:String , val subtitle : String)

fun getCategoryList():MutableList<Category>{
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Sumit kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Amit kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Gagan kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Abhishek kumar", "Web Developer"))
    list.add(Category(R.drawable.user, "Aman kumar", "Software Developer"))
    list.add(Category(R.drawable.user, "Nitish kumar", "Web Developer"))

    return list
}