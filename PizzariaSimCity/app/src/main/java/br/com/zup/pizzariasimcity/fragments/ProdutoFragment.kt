package br.com.zup.pizzariasimcity.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.pizzariasimcity.FragmentoClick
import br.com.zup.pizzariasimcity.databinding.FragmentProdutoBinding
import br.com.zup.pizzariasimcity.home.HomeActivity

class ProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding
    private lateinit var interfaceClick: FragmentoClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            interfaceClick = context as HomeActivity
        }catch (ex: Exception){
            Log.i("Error", "Erro na inicialização da interfaceClick ${ex.message}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutoBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNomePizza.setOnClickListener {
            interfaceClick.clickFragmento("Essa pizza de marguerita é ótima!")
        }
    }
}