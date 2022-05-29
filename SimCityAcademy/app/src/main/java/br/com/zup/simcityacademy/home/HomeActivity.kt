package br.com.zup.simcityacademy.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.informacao.InformacaoActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var editTextNomeAlune: EditText
    private val editTextNotaUm: EditText by lazy { findViewById(R.id.etNotaUm) }
    private val editTextNotaDois: EditText by lazy { findViewById(R.id.etNotaDois) }
    private var btnCalcularMédia: Button? = null

    //TODO dicionar viewBinding no projeto para vincular os campos de nota três e quatro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()

        btnCalcularMédia?.setOnClickListener {
            //TODO alterar o código abaixo
            startActivity(Intent(this, InformacaoActivity::class.java))
        }

    }

    private fun initViews(){
        editTextNomeAlune = findViewById(R.id.etNomeAlune)
        btnCalcularMédia = findViewById(R.id.btnCalcularMedia)
    }

    private fun enviarDadosAlune(){
        //TODO realizar a lógica para recuperar os dados
        //TODO realizar a lógica para enviar os dados
    }
}