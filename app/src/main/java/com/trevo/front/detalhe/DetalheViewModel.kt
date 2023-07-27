package com.trevo.front.detalhe

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trevo.front.data.DataSource
import com.trevo.front.data.Produto

class DetalheViewModel(val dataSource: DataSource) : ViewModel() {
    fun addToOrcamento(product: Produto) {
        dataSource.addProduct(product)
    }
}

class DetalheViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalheViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetalheViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}