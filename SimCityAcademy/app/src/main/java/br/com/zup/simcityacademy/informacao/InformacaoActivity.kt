package br.com.zup.simcityacademy.informacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.simcityacademy.*
import br.com.zup.simcityacademy.databinding.ActivityInformacaoBinding
import br.com.zup.simcityacademy.model.Alune

class InformacaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_informacoes)

        recuperarExibirDados()
    }

    private fun recuperarExibirDados() {
        val alune = intent.getParcelableExtra<Alune>(ALUNE)

        if (alune != null) {
            exibirNomeAlune(alune.getNome())
            val media = calcularMediaAlune(
                alune.getNotaUm(),
                alune.getNotaDois(),
                alune.getNotaTres(),
                alune.getNotaQuatro()
            )
            exibirMediaAlune(media)
            exibirMensagemAlune(media)
        }
    }

    private fun exibirNomeAlune(nome: String) {
        binding.tvNomeAlune.text = nome
    }

    private fun calcularMediaAlune(
        notaUm: Double,
        notaDois: Double,
        notaTres: Double,
        notaQuatro: Double
    ): Double {
        return (notaUm + notaTres + notaDois + notaQuatro) / 4
    }

    private fun exibirMediaAlune(
        media: Double
    ) {
        binding.tvMediaAlune.text = media.toString()
    }

    private fun exibirMensagemAlune(media: Double) {
        if (media >= 7) {
            binding.tvMensagem.text = getString(R.string.mensagem_aprovade)
        } else {
            binding.tvMensagem.text = getString(R.string.mensagem_reprovade)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}