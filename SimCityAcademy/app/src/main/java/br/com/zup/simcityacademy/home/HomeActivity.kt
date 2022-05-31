package br.com.zup.simcityacademy.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.zup.simcityacademy.*
import br.com.zup.simcityacademy.databinding.ActivityHomeBinding
import br.com.zup.simcityacademy.informacao.InformacaoActivity
import br.com.zup.simcityacademy.model.Alune

class HomeActivity : AppCompatActivity() {
    private lateinit var editTextNomeAlune: EditText
    private val editTextNotaUm: EditText by lazy { findViewById(R.id.etNotaUm) }
    private val editTextNotaDois: EditText by lazy { findViewById(R.id.etNotaDois) }
    private var btnCalcularMédia: Button? = null

    /**
     * Declaração do viewBinding no projeto
     */
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Inicialização da variavel binding
         */
        binding = ActivityHomeBinding.inflate(layoutInflater)
        /**
         * Adicionando o binding.root para o método que seta o layout que será exibido ao usuário
         */
        setContentView(binding.root)

        initViews()

        /**
         * Exemplo de uso do binding pelo id da view
         */
        binding.etNotaTres


        btnCalcularMédia?.setOnClickListener {
            enviarDadosAlune()
        }
        limparOsCamposEdicao()
    }

    private fun initViews() {
        editTextNomeAlune = findViewById(R.id.etNomeAlune)
        btnCalcularMédia = findViewById(R.id.btnCalcularMedia)
    }

    private fun enviarDadosAlune() {
        val nomeAlune = binding.etNomeAlune.text.toString()
        val primeiraNota = binding.etNotaUm.text.toString()
        val segundaNota = binding.etNotaDois.text.toString()
        val terceiraNota = binding.etNotaTres.text.toString()
        val quartaNota = binding.etNotaQuatro.text.toString()

        if (nomeAlune.isNotEmpty() && nomeAlune != null
            && primeiraNota.isNotEmpty()
            && segundaNota.isNotEmpty()
            && terceiraNota.isNotEmpty()
            && quartaNota.isNotEmpty()
        ) {

            val alune = Alune(
                nomeAlune,
                primeiraNota.toDouble(),
                segundaNota.toDouble(),
                terceiraNota.toDouble(),
                quartaNota.toDouble()
            )

            val intent = Intent(this, InformacaoActivity::class.java).apply {
                putExtra(ALUNE, alune)
            }

            startActivity(intent)
        }else{
            binding.etNomeAlune.error = "campo obrigatorio!"
            binding.etNotaUm.error = "campo obrigatorio!"
            binding.etNotaDois.error = "campo obrigatorio!"
            binding.etNotaTres.error = "campo obrigatorio!"
            binding.etNotaQuatro.error = "campo obrigatorio!"
        }

    }

    private fun limparOsCamposEdicao() {
        binding.etNomeAlune.text.clear()
        binding.etNotaUm.text.clear()
        binding.etNotaDois.text.clear()
        binding.etNotaTres.text.clear()
        binding.etNotaQuatro.text.clear()
    }
}