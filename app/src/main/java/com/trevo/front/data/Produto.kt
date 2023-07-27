package com.trevo.front.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Produto(
    @SerializedName("id")
    val id: Long,

    @SerializedName("nome")
    val nome: String,

    @SerializedName("culturaUtilizada")
    val culturaUtilizada: String,

    @SerializedName("descricaoProduto")
    val descricaoProduto: String,

    @SerializedName("areaSuportada")
    val areaSuportada: String,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("dataCadastro")
    val dataCadastro: Date,

    @SerializedName("status")
    val status: String
) : Parcelable