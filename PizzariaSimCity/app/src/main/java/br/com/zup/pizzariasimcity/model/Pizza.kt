package br.com.zup.pizzariasimcity.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pizza(
    private var nome: String,
    private var descricao: String
) : Parcelable {
    fun getNomePizza() = this.nome
    fun getDescricaoPizza() = this.descricao
}