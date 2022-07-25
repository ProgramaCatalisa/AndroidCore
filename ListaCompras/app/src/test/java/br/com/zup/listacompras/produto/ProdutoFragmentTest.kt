package br.com.zup.listacompras.produto

import androidx.navigation.NavController
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock

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

    @Test
    fun recuperarDadosCampoEdicao_OnlyDescricaoEmpty_reutrnNull(){
        val prodFragment =ProdutoFragment()
        val produto = prodFragment.recuperarDadosCampoEdicao(
            nomeProduto = "alguma coisa",
            descricaoProduto = ""
        )
        assert(produto == null)
    }
}