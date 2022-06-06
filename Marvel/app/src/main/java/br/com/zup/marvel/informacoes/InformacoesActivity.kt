package br.com.zup.marvel.informacoes

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityInformacoesBinding
import br.com.zup.marvel.informacoes.adapter.InformacoesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class InformacoesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformacoesBinding
    private val listaTitulos = listOf("Filme", "HQs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        exibirViewPagerTabLayout()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.informacoes_name)
    }

    private fun exibirViewPagerTabLayout() {
        val adapter = InformacoesPagerAdapter(supportFragmentManager, lifecycle, listaTitulos)
        binding.vpInformacoes.adapter = adapter

        TabLayoutMediator(binding.tbInformacoes, binding.vpInformacoes) { tab, position ->
            tab.text = listaTitulos[position]
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}