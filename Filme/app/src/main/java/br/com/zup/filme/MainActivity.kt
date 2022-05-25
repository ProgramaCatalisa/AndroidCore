package br.com.zup.filme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoMensagem = findViewById<Button>(R.id.botao_mensagem)

        /**
         * método setOnClickListener que escuta toda vez que um usuário clica em um botão
         * e executa a lógica que estiver entre as chaves
         */
        botaoMensagem.setOnClickListener {
            Toast.makeText(this, "Esse filme é maravilhoso!", Toast.LENGTH_LONG).show()
        }

        val botaoDetalheFilme = findViewById<Button>(R.id.botao_detalhe_filme)

        /**
         * Criação de uma intenção que fará com que o usuário saia da MainActivity e vá
         * para o DetalheFilmeActivity
         */
        botaoDetalheFilme.setOnClickListener {
            val intent = Intent(this, DetalheFilmeActivity::class.java)
            startActivity(intent)
        }
    }
}