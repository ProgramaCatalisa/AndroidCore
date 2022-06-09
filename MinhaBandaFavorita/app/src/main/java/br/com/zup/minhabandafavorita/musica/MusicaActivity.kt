package br.com.zup.minhabandafavorita.musica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.minhabandafavorita.ALBUM_KEY
import br.com.zup.minhabandafavorita.databinding.ActivityMusicaBinding
import br.com.zup.minhabandafavorita.model.Album

class MusicaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Musica Activity")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val album = intent.getParcelableExtra<Album>(ALBUM_KEY)
        if (album != null) {

            val fragmentoMusica = MusicaAlbumFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ALBUM_KEY, album)
                }
            }

            supportFragmentManager
                .beginTransaction()
                .add(binding.clMusicaContainer.id, fragmentoMusica)
                .addToBackStack("Musica")
                .commit()
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