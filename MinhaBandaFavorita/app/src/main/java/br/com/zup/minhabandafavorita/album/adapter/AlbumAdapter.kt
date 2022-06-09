package br.com.zup.minhabandafavorita.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minhabandafavorita.databinding.AlbumItemBinding
import br.com.zup.minhabandafavorita.model.Album

class AlbumAdapter(
    private var listaAlbum: MutableList<Album>
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun exibirDadosItemLista(album: Album){
            binding.ivAlbum.setImageResource(album.getImage())
        }
    }
}