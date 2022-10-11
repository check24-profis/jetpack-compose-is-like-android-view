package de.check24.compose.demo

import java.util.concurrent.atomic.AtomicInteger

internal object UIDGenerator {

    private const val START_UID = 0

    /**
     * https://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/
     */
    private val nextUID = AtomicInteger(START_UID)

    fun newUID(): Int {
        if (!isValid(nextUID.get())) {
            error("UID pool depleted")
        }
        return nextUID.incrementAndGet()
    }

    private fun isValid(uid: Int): Boolean = uid >= START_UID
}