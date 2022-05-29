package br.com.zup.filme

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "APP_FILME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Passou pelo onCreate() da main")
        setContentView(R.layout.activity_main)

        val botaoMensagem = findViewById<Button>(R.id.botao_mensagem)

        /**
         * método setOnClickListener que escuta toda vez que um usuário clica em um botão
         * e executa a lógica que estiver entre as chaves
         */
        botaoMensagem.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, "emaildo@diretor.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
            intent.putExtra(Intent.EXTRA_TEXT, "Eu sou o corpo do email")

            startActivity(intent)
        }

        val botaoDetalheFilme = findViewById<Button>(R.id.botao_detalhe_filme)

        /**
         * Criação de uma intenção que fará com que o usuário saia da MainActivity e vá
         * para o DetalheFilmeActivity
         */
        botaoDetalheFilme.setOnClickListener {

            val intent = Intent(this, DetalheFilmeActivity::class.java)

            val nomeDoFilme = "seu filme"
            val bundle = Bundle()
            bundle.putString("nomeDoFilme", nomeDoFilme)
            intent.putExtra("Message", bundle)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Passou pelo onStart() da main")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Passou pelo onResune() da main")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Passou pelo onPause() da main")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Passou pelo onStop() da main")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Passou pelo onDestroy() da main")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Passou pelo onRestart() da main")
    }
}