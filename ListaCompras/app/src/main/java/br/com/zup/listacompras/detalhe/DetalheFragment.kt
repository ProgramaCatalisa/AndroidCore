package br.com.zup.listacompras.detalhe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.listacompras.CHAVE_PRODUTO
import br.com.zup.listacompras.databinding.FragmentDetalheBinding
import br.com.zup.listacompras.model.Produto

class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentDetalheBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarExibirDadosProduto()
    }

    private fun recuperarExibirDadosProduto() {
        val produto = arguments?.getParcelable<Produto>(CHAVE_PRODUTO)
        if (produto != null){
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvDescricaoProduto.text = produto.getDescricao()
        }
    }

}