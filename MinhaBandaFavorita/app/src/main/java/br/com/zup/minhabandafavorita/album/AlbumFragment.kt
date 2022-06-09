package br.com.zup.minhabandafavorita.album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.minhabandafavorita.R
import br.com.zup.minhabandafavorita.album.adapter.AlbumAdapter
import br.com.zup.minhabandafavorita.databinding.FragmentAlbumBinding
import br.com.zup.minhabandafavorita.model.Album

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding

    private val albumAdapter: AlbumAdapter by lazy {
        AlbumAdapter(arrayListOf(), ::irParaDetalheAlbum)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exibirRecyclerView()
    }

    private fun exibirRecyclerView(){
        binding.rvListaAlbum.adapter = albumAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context, 2)
        criarListaAlbum()
    }

    private fun criarListaAlbum() {
        val listaAlbum = mutableListOf<Album>()

        listaAlbum.add(Album(R.drawable.album1, "Album 1"))

        val album2 = Album(R.drawable.album2, "Album 2")
        listaAlbum.add(album2)

        listaAlbum.add(Album(R.drawable.album3, "Album 3"))

        listaAlbum.add(Album(R.drawable.album6, "Album 4"))

        albumAdapter.atualizarListaAlbuns(listaAlbum)
    }

    private fun irParaDetalheAlbum(album: Album){
        Toast.makeText(context, "Item clicado ${album.getName()}", Toast.LENGTH_LONG).show()
    }
}