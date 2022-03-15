package de.check24.compose.demo.features.list.differentviews

sealed class ExampleListItems {

    data class TitleItem(
        val title: String
    ) : ExampleListItems()

    data class ContentItem(
        val title: String,
        val body: String
    ) : ExampleListItems()

}