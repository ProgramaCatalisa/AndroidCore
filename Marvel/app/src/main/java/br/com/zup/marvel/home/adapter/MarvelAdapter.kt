package br.com.zup.marvel.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.MarvelItemBinding
import br.com.zup.marvel.model.Marvel

class MarvelAdapter(
    private var listaHerois: MutableList<Marvel>,
    private val clickHeroi: (heroi: Marvel) -> Unit
) : RecyclerView.Adapter<MarvelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MarvelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val marvelHeroi = listaHerois[position]
        holder.adicionarInformacoesView(marvelHeroi)
        holder.binding.cvItemLista.setOnClickListener {
            clickHeroi(marvelHeroi)
        }
    }

    override fun getItemCount() = listaHerois.size

    fun atualizarListaProduto(novaLista: MutableList<Marvel>) {
        if (listaHerois.size == 0) {
            listaHerois = novaLista
        } else {
            listaHerois.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MarvelItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun adicionarInformacoesView(heroi: Marvel) {
            binding.ivHeroi.setImageResource(heroi.getImage())
            binding.tvNomeHeroi.text = heroi.getNome()
        }
    }
}