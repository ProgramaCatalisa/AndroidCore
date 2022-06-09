package br.com.zup.minhamusicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Album(
    private var imagem: Int,
    private var nome: String
) : Parcelable {
    fun getImagem() = this.imagem
    fun getNome() = this.nome
}