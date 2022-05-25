package br.com.zup.filme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class DetalheFilme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_filme)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_detalhe_filme)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}