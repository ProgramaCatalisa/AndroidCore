package br.com.zup.minhamusicafavorita.detalhe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.minhamusicafavorita.CHAVE_ALBUM
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.databinding.FragmentDetalheAlbumBinding
import br.com.zup.minhamusicafavorita.model.Album

class DetalheAlbumFragment : Fragment() {
    private lateinit var binding: FragmentDetalheAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarExibirDadosProduto()
    }

    private fun recuperarExibirDadosProduto() {
        val album = arguments?.getParcelable<Album>(CHAVE_ALBUM)
        if (album != null){
            binding.tvDetalheNomeAlbum.text = album.getNome()
            binding.ivDetalheAlbum.setImageResource(album.getImagem())
        }
    }
}