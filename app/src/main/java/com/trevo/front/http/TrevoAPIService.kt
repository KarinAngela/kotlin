package com.trevo.front.http

import com.trevo.front.data.Produto
import retrofit2.Call
import retrofit2.http.GET

interface TrevoAPIService {
    @GET("/produtos")
    fun listProducts() : Call<List<Produto>>
}