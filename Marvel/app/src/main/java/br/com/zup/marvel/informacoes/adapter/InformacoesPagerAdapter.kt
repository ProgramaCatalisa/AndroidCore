package br.com.zup.marvel.informacoes.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.marvel.informacoes.filme.FilmeFragment
import br.com.zup.marvel.informacoes.quadrinhos.QuadrinhosFragment

class InformacoesPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle,
    private val listaTitulos: List<String>
) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = listaTitulos.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FilmeFragment()
            1 -> return QuadrinhosFragment()
        }
        return FilmeFragment()
    }
}