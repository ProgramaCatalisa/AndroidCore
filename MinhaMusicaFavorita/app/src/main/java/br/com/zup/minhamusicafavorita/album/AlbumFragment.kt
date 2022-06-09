package br.com.zup.minhamusicafavorita.album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.zup.minhamusicafavorita.CHAVE_ALBUM
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.album.adapter.AlbumAdapter
import br.com.zup.minhamusicafavorita.databinding.FragmentAlbumBinding
import br.com.zup.minhamusicafavorita.model.Album

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

    private fun exibirRecyclerView() {
        binding.rvListaAlbuns.adapter = albumAdapter
        binding.rvListaAlbuns.layoutManager = GridLayoutManager(context, 2)
        adicionarAlbum()
    }

    private fun adicionarAlbum(){
        val listaAlbum = mutableListOf<Album>()

        listaAlbum.add(
            Album(R.drawable.album1, "Album 1")
        )

        listaAlbum.add(
            Album(R.drawable.album2, "Album 2")
        )

        listaAlbum.add(
            Album(R.drawable.album3, "Album 1")
        )

        listaAlbum.add(
            Album(R.drawable.album4, "Album 2")
        )

        listaAlbum.add(
            Album(R.drawable.album1, "Album 1")
        )

        listaAlbum.add(
            Album(R.drawable.albun5, "Album 2")
        )
        listaAlbum.add(
            Album(R.drawable.album6, "Album 2")
        )

        albumAdapter.atualizarListaProduto(listaAlbum)
    }

    private fun irParaDetalheAlbum(album: Album) {

        val bundle = bundleOf(CHAVE_ALBUM to album)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_albumFragment_to_detalheAlbumFragment, bundle
        )
    }
}