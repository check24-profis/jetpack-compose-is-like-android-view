package de.check24.compose.demo

import de.check24.compose.demo.features.sideeffects.ComposableLaunchedEffectActivity

internal val singleItemList: List<SingleItem> by lazy {
    val singleItems = mutableListOf<SingleItem>()

    singleItems.add(
        SingleItem(
            activity = ComposableLaunchedEffectActivity::class.java,
            headline = "Launched Effect"
        )
    )

    singleItems
}
