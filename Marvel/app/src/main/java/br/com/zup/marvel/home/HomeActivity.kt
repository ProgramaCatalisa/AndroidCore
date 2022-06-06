package br.com.zup.marvel.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.*
import br.com.zup.marvel.home.adapter.MarvelAdapter
import br.com.zup.marvel.databinding.ActivityHomeBinding
import br.com.zup.marvel.detalhe.DetalheActivity
import br.com.zup.marvel.informacoes.InformacoesActivity
import br.com.zup.marvel.model.Marvel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val adapter: MarvelAdapter by lazy {
        MarvelAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirRecyclerView()

        binding.bvInformacoesMarvel.setOnClickListener {
            startActivity(Intent(this, InformacoesActivity::class.java))
        }
    }

    private fun exibirRecyclerView() {
        adicionarItemListaProduto()
        binding.rvHerois.adapter = adapter
        binding.rvHerois.layoutManager = LinearLayoutManager(this)
    }

    private fun adicionarItemListaProduto() {
        val listaHerois = mutableListOf<Marvel>()

        listaHerois.add(
            Marvel(
                R.drawable.gamora,
                GAMORRA_NOME,
                GAMORRA_DESCRICAO
            )
        )

        listaHerois.add(
            Marvel(
                R.drawable.homem_ferro,
                HOMEM_FERRO_NOME,
                HOMEM_FERRO_DESCRICAO
            )
        )

        listaHerois.add(
            Marvel(
                R.drawable.mulher_invisivel,
                MULHER_INIVISVEL_NOME,
                MULHER_INVISVEL_DESCRICAO
            )
        )
        adapter.atualizarListaProduto(listaHerois)
    }

    private fun irParaDetalhe(heroi: Marvel) {
        val intent = Intent(this, DetalheActivity::class.java).apply {
            putExtra(MARVEL_KEY, heroi)
        }
        startActivity(intent)
    }

}