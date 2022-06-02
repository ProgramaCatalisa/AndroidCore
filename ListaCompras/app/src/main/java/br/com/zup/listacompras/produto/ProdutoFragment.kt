package br.com.zup.listacompras.produto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.listacompras.CHAVE_PRODUTO
import br.com.zup.listacompras.R
import br.com.zup.listacompras.databinding.FragmentProdutoBinding
import br.com.zup.listacompras.model.Produto

class ProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding

    //TODO criar e inicializar o Adapter

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
        //TODO fazer a lógica para exibir o RecyclerView
    }

    private fun adicionarItemListaProduto() {
        //TODO fazer a lógica para adicionar um item em uma lista
    }

    private fun irParaDetalheProduto(produto: Produto) {

        val bundle = bundleOf(CHAVE_PRODUTO to produto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_produtoFragment_to_detalheFragment, bundle
        )
    }

    private fun recuperarDadosCampoEdicao(): Produto? {
        val nomeProduto = binding.etNomeProduto.text.toString()
        val descricaoProduto = binding.etDetalheProduto.text.toString()

        if (nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty()) {
            limparCampoEdicao()
            return Produto(nomeProduto, descricaoProduto)
        }
        return null
    }

    private fun exibirMensagemErro() {
        binding.etNomeProduto.error = "Por favor preencha o campo de nome"
        binding.etDetalheProduto.error = "Por favor preencha o campo de detalhe"
    }

    private fun limparCampoEdicao() {
        binding.etNomeProduto.text.clear()
        binding.etDetalheProduto.text.clear()
    }
}