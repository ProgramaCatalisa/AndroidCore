package br.com.zup.minhabandafavorita.detalhe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.minhabandafavorita.ALBUM_KEY
import br.com.zup.minhabandafavorita.R
import br.com.zup.minhabandafavorita.databinding.FragmentDetalheAlbumBinding
import br.com.zup.minhabandafavorita.model.Album

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
        recuperarExibirAlbum()
    }

    private fun recuperarExibirAlbum() {
        val album = arguments?.getParcelable<Album>(ALBUM_KEY)

        if (album != null) {
            binding.ivDetalheAlbum.setImageResource(album.getImage())
            binding.tvDetalheAlbum.text = album.getName()
        }
    }
}