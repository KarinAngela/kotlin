package com.trevo.front.ui.orcamento

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrcamentoViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is orcamento Fragment"
    }
    val text: LiveData<String> = _text
}