package br.com.zup.marvel.informacoes.quadrinhos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.marvel.databinding.FragmentQuadrinhosBinding

class QuadrinhosFragment : Fragment() {
    private lateinit var binding: FragmentQuadrinhosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuadrinhosBinding.inflate(inflater, container, false)
        return binding.root
    }
}