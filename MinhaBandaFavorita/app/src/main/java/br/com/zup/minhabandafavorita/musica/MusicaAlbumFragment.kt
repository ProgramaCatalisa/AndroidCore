package br.com.zup.minhabandafavorita.musica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.minhabandafavorita.ALBUM_KEY
import br.com.zup.minhabandafavorita.databinding.FragmentMusicaAlbumBinding
import br.com.zup.minhabandafavorita.model.Album

class MusicaAlbumFragment : Fragment() {
    private lateinit var binding: FragmentMusicaAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicaAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val album = arguments?.getParcelable<Album>(ALBUM_KEY)
        if (album != null) {
            binding.tvMusicaDetalhe.text = album.getName()
            binding.ivMusicaDetalhe.setImageResource(album.getImage())
        }
    }
}