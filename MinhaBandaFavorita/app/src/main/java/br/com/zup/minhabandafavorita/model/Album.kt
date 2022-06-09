package br.com.zup.minhabandafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Album(
    private var albumImage: Int,
    private var albumName: String
) : Parcelable {
    fun getImage() = this.albumImage
    fun getName() = this.albumName
}