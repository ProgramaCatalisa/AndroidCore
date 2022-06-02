package br.com.zup.listacompras.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.listacompras.databinding.ProdutoItemBinding
import br.com.zup.listacompras.model.Produto

class ProdutoAdapter(
    private var listaProduto: MutableList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit
) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.adicionarInformacoesView(produto)
        holder.binding.cvItemLista.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int = listaProduto.size

    fun atualizarListaProduto(novaLista: MutableList<Produto>) {
        if (listaProduto.size == 0) {
            listaProduto = novaLista
        } else {
            listaProduto.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun adicionarInformacoesView(produto: Produto) {
            binding.rvItemNomeProduto.text = produto.getNome()
        }
    }
}