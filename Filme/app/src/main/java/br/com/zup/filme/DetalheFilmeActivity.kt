package br.com.zup.filme

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DetalheFilmeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(MainActivity.TAG, "Passou pelo onCreate() do detalhe")


        setContentView(R.layout.activity_detalhe_filme)

        val bundle = intent.getBundleExtra("Message")
        val nomeDoFilme = bundle!!.getString("nomeDoFilme")
        Toast.makeText(this, nomeDoFilme, Toast.LENGTH_LONG).show()

        /**
         * Método que habilita o back button(botão de voltar)
         * na toolbar da tela
         */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /**
         * Método que seta o título da tela na toolbar referenciando um valor que está
         * adicionado no arquivo de strings.xml
         */
        supportActionBar?.setTitle(R.string.titulo_detalhe_filme)
    }

    /**
     * Este método habilitará voltar a tela quando o botão de voltar for precionado
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        Log.d(MainActivity.TAG, "Passou pelo onStart() do detalhe")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MainActivity.TAG, "Passou pelo onResune() do detalhe")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MainActivity.TAG, "Passou pelo onPause() do detalhe")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MainActivity.TAG, "Passou pelo onStop() do detalhe")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MainActivity.TAG, "Passou pelo onDestroy() do detalhe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MainActivity.TAG, "Passou pelo onRestart() do detalhe")
    }
}