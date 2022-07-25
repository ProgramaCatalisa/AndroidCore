package br.com.zup.listacompras.produto

import org.junit.Assert.*
import org.junit.Test

class ProdutoFragmentTest{

    @Test
    fun recuperarDadosCampoEdicao_OnlyNomeEmpty_reutrnNull(){
        val prodFragment =ProdutoFragment()
        val produto = prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "",
            descricaoProduto = "alguma coisa"
        )
        assert(produto == null)
    }
}