package com.sachet.view_add.view_modal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModal: ViewModel() {
    var result = MutableLiveData(0)
    fun addNum(num: Int) {
        result.value = result.value?.let {it -> it + num }
    }
}