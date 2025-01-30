package screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstcompose.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: () -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteListItem(quote = it) {
                onClick()
            }
        }
    })
//    LazyColumn {
//        items(data) { quote ->  // Ensure 'data' is a List or an Iterable
//            QuoteListItem(quote = quote) {
//                onClick(quote)  // Ensure onClick is a lambda reference
//            }
//        }
//    }

}
