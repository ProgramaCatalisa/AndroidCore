package br.com.zup.simcityacademy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Para utilizar o Parcelable no projeto nao esqueça de adicionar
 * o plugin id 'kotlin-parcelize' no build.gradle do app
 */
@Parcelize
class Alune(
    private var nome: String,
    private var notaUm: Double,
    private var notaDois: Double,
    private var notaTres: Double,
    private var notaQuatro: Double
) : Parcelable {

    /**
     * exemplo de inline function caracteristica do Kotlin para funções de retorno
     * simples
     */
    fun getNome() = this.nome
    fun getNotaUm() = this.notaUm
    fun getNotaDois() = this.notaDois
    fun getNotaTres() = this.notaTres
    fun getNotaQuatro() = this.notaQuatro
}