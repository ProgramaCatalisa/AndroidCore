package br.com.zup.simcityacademy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Alune(
    private var nome: String,
    private var notaUm: Double,
    private var notaDois: Double,
    private var notaTres: Double,
    private var notaQuatro: Double
) : Parcelable {

    fun getNome() = this.nome
    fun getNotaUm() = this.notaUm
    fun getNotaDois() = this.notaDois
    fun getNotaTres() = this.notaTres
    fun getNotaQuatro() = this.notaQuatro
}