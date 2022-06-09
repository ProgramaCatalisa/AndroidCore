package br.com.zup.minhabandafavorita.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minhabandafavorita.ALBUM_KEY
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
        criarListaAlbum()
    }

    private fun exibirRecyclerView(){
        binding.rvListaAlbum.adapter = albumAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context, 2)
    }

    private fun criarListaAlbum() {
        val listaAlbum = mutableListOf<Album>()

        listaAlbum.add(Album(R.drawable.album1, "Album 1"))

        val album2 = Album(R.drawable.album2, "Album 2")
        listaAlbum.add(album2)

        listaAlbum.add(Album(R.drawable.album3, "Album 3"))

        listaAlbum.add(Album(R.drawable.album6, "Album 4"))

        albumAdapter.atualizarListaAlbuns(listaAlbum)
        exibirRecyclerView()
    }

    private fun irParaDetalheAlbum(album: Album){
       val bundle = bundleOf(ALBUM_KEY to album)

        NavHostFragment.findNavController(this).navigate(
           R.id.action_albumFragment2_to_detalheAlbumFragment2, bundle
        )
    }
}