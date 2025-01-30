package com.example.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Notification(count: Int, increment: () -> Unit) {
    Column {
        Text(text = "You have sent $count notifications")
        Button(onClick = {increment()}) {
            Text(text = "Send Notification")
        }
    }

}
@Composable
fun MessageBar(count: Int) {
    Card  {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.heart),
                contentDescription = "notification",
                modifier = Modifier.size(30.dp)
                    .padding(5.dp))
            Text(text = "Messages sent so far - $count")
        }
    }
}