package com.trevo.front.orcamento

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trevo.front.data.DataSource
import com.trevo.front.data.Produto

class OrcamentoViewModel(val dataSource: DataSource): ViewModel() {
    val productsLiveData = dataSource.getProductList()

    fun insertProduct(product: Produto) {
        dataSource.addProduct(product)
    }
}

class OrcamentoViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrcamentoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OrcamentoViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}