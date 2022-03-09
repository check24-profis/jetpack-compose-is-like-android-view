package de.check24.demo.features.list.differentviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.check24.demo.features.list.differentviews.ExampleListItems
import de.check24.demo.ui.theme.DemoTheme

class ComposableListWithDifferentViewsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleList = mutableListOf(
            ExampleListItems.TitleItem("I am a title"),
            ExampleListItems.TitleItem("I am a title"),
            ExampleListItems.ContentItem("I am a title", "I am body"),
            ExampleListItems.TitleItem("I am a title")
        )

        setContent {
            DemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Password")
                            })
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ExampleItemsListView(listOfExampleItems = exampleList)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ExampleItemsListView(listOfExampleItems: List<ExampleListItems>) {

    LazyColumn {
        items(listOfExampleItems) { item ->
            when (item) {
                is ExampleListItems.TitleItem -> TitleItemView(item = item)
                is ExampleListItems.ContentItem -> ContentItemView(item = item)
            }
        }
    }
}

@Composable
fun TitleItemView(item: ExampleListItems.TitleItem) {

    Row(
        modifier = Modifier
            .background(color = Color.LightGray)
            .padding(all = 20.dp)
    ) {
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ContentItemView(item: ExampleListItems.ContentItem) {

    Row(
        modifier = Modifier
            .background(color = Cyan)
            .padding(all = 20.dp)
    ) {
        Column {
            Text(
                text = item.title,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            Text(
                text = item.body,
                fontWeight = FontWeight.ExtraLight
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ExampleItemsListPreview() {

    val exampleList = mutableListOf(
        ExampleListItems.TitleItem("I am a title"),
        ExampleListItems.TitleItem("I am a title"),
        ExampleListItems.ContentItem("I am a title", "I am body"),
        ExampleListItems.TitleItem("I am a title")
    )
    DemoTheme {
        ExampleItemsListView(listOfExampleItems = exampleList)
    }
}