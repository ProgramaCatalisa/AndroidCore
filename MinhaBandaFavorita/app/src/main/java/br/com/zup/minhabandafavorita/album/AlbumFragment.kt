package br.com.zup.minhabandafavorita.album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.minhabandafavorita.R
import br.com.zup.minhabandafavorita.model.Album


class AlbumFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    private fun criarListaAlbum() {
        val listaAlbum = mutableListOf<Album>()

        listaAlbum.add(Album(R.drawable.album1, "Album 1"))

        val album2 = Album(R.drawable.album2, "Album 2")
        listaAlbum.add(album2)

        listaAlbum.add(Album(R.drawable.album3, "Album 3"))

        listaAlbum.add(Album(R.drawable.album6, "Album 4"))
    }
}