package br.com.zup.marvel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Marvel(
    private var imagem: Int,
    private var nome: String,
    private var detalhe: String
) : Parcelable {

    fun getImage() = this.imagem
    fun getNome() = this.nome
    fun getDetalhe() = this.detalhe
}