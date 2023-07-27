package com.trevo.front.data

import android.content.res.Resources
import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val productLiveData = MutableLiveData<List<Produto>>()

    fun addProduct(product: Produto) {
        val currentList = productLiveData.value

        if (currentList == null) {
            productLiveData.postValue(listOf(product))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, product)
            productLiveData.postValue(updatedList)
        }
    }

    fun removeProduct(id: Long): Produto? {
        productLiveData.value?.let { products ->
            return products.firstOrNull{ it.id == id }
        }
        return null
    }

    fun getProductList(): LiveData<List<Produto>> {
        return productLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

//      Padrão Singleton para gerar objetos DataSource
        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}