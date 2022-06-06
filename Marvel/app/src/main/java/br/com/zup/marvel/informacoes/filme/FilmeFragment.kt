package br.com.zup.marvel.informacoes.filme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.marvel.databinding.FragmentFilmeBinding

class FilmeFragment : Fragment() {
    private lateinit var binding: FragmentFilmeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmeBinding.inflate(inflater, container, false)
        return binding.root
    }
}