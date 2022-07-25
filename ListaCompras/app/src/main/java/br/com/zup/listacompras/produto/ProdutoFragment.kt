package br.com.zup.listacompras.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.listacompras.CHAVE_PRODUTO
import br.com.zup.listacompras.R
import br.com.zup.listacompras.adapter.ProdutoAdapter
import br.com.zup.listacompras.databinding.FragmentProdutoBinding
import br.com.zup.listacompras.model.Produto

class ProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding

    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalheProduto)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirRecyclerView()

        binding.bvAdicionar.setOnClickListener {
            adicionarItemListaProduto()
        }
    }

    private fun exibirRecyclerView() {
        binding.rvListaProdutos.adapter = adapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)
    }

    private fun adicionarItemListaProduto() {
        val listaProduto = mutableListOf<Produto>()
        val produtoRecebido = recuperarDadosCampoEdicao()

        if (produtoRecebido != null) {
            listaProduto.add(produtoRecebido)
            adapter.atualizarListaProduto(listaProduto)
            exibirRecyclerView()
        } else {
            exibirMensagemErro()
        }
    }

    private fun irParaDetalheProduto(produto: Produto) {

        val bundle = bundleOf(CHAVE_PRODUTO to produto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_produtoFragment_to_detalheFragment, bundle
        )
    }

    fun recuperarDadosCampoEdicao(
        nomeProduto : String = binding.etNomeProduto.text.toString(),
        descricaoProduto : String = binding.etDetalheProduto.text.toString()
    ): Produto? {

        if (nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty()) {
            limparCampoEdicao()
            return Produto(nomeProduto, descricaoProduto)
        }
        return null
    }

    private fun exibirMensagemErro() {
        if(binding.etNomeProduto.text.isEmpty()){
            binding.etNomeProduto.error = "Por favor preencha o campo de nome"
        }
        if(binding.etDetalheProduto.text.isEmpty()){
            binding.etDetalheProduto.error = "Por favor preencha o campo de detalhe"
        }

    }

    private fun limparCampoEdicao() {
        binding.etNomeProduto.text.clear()
        binding.etDetalheProduto.text.clear()
    }
}