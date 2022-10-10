package de.check24.compose.demo

import de.check24.compose.demo.features.list.lazyperformance.LazyColumnPerformanceActivity
import de.check24.compose.demo.features.sideeffects.ComposableDisposableEffectActivity
import de.check24.compose.demo.features.sideeffects.ComposableLaunchedEffectActivity
import de.check24.compose.demo.features.sideeffects.ComposableSideEffectActivity

internal val singleItemList: List<SingleItem> by lazy {
    val singleItems = mutableListOf<SingleItem>()

    singleItems.add(
        SingleItem(
            activity = ComposableLaunchedEffectActivity::class.java,
            headline = "Launched Effect"
        )
    )
    singleItems.add(
        SingleItem(
            activity = ComposableDisposableEffectActivity::class.java,
            headline = "Disposable Effect"
        )
    )
    singleItems.add(
        SingleItem(
            activity = ComposableSideEffectActivity::class.java,
            headline = "Side Effect"
        )
    )

    singleItems.add(
        SingleItem(
            activity = LazyColumnPerformanceActivity::class.java,
            headline = "LazyColumn Performance"
        )
    )

    singleItems
}
