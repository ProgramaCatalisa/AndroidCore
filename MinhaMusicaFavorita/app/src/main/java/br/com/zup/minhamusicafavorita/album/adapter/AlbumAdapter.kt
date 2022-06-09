package br.com.zup.minhamusicafavorita.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minhamusicafavorita.databinding.AlbumItemBinding
import br.com.zup.minhamusicafavorita.model.Album

class AlbumAdapter(
    private var listaAlbuns: MutableList<Album>,
    private val clickAlbum: (album: Album) -> Unit
) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = listaAlbuns[position]
        holder.exibirInformacoesView(album)
        holder.binding.cvAlbum.setOnClickListener {
            clickAlbum(album)
        }
    }

    override fun getItemCount(): Int = listaAlbuns.size

    fun atualizarListaProduto(novaListaAlbum: MutableList<Album>) {
        if (listaAlbuns.size == 0) {
            listaAlbuns = novaListaAlbum
        } else {
            listaAlbuns.addAll(novaListaAlbum)
        }

        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun exibirInformacoesView(album: Album) {
            binding.ivAlbum.setImageResource(album.getImagem())
        }
    }
}