package de.check24.compose.demo.features.events

import androidx.lifecycle.ViewModel

class EventViewModel : ViewModel() {
    var number = 0

    fun plusOne() {
        number++
    }

    fun minusOne(){
        number--
    }
}