package com.trevo.front.data

import java.util.Date

data class Produto(
    val id: Long,
    val nome: String,
    val cultura_utilizada: String,
    val descricao_produto: String,
    val area_suportada: String,
    val image_url: String,
    val data_cadastro: Date,
    val status: String
)