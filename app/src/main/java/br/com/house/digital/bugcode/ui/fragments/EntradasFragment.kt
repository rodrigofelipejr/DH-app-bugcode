package br.com.house.digital.bugcode.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.`interface`.IContractMainActivity
import kotlinx.android.synthetic.main.fragment_entradas.view.*

class EntradasFragment : Fragment() {
    private lateinit var contractMainActivity: IContractMainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_entradas, container, false)
        return init(view)
    }

    companion object {
        fun newInstance() = EntradasFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is IContractMainActivity) {
            contractMainActivity = context
        }
    }

    private fun init(view: View):View {
        view.button_detalhes.setOnClickListener{
            contractMainActivity.irParaDetalhes("Foi do EntradasFragent")
        }
        return view
    }
}