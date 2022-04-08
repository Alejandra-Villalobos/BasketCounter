package com.villalobos.basketcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllViewModel : ViewModel() {
    var scoreA = MutableLiveData("0")
    var scoreB = MutableLiveData("0")
    var winner = MutableLiveData("")

}