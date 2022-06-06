package br.com.zup.marvel.informacoes

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityInformacoesBinding

class InformacoesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformacoesBinding

    //TODO criar o PagerAdapater

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
        //TODO implementar a exibição do viewPager e do TabLayout
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}