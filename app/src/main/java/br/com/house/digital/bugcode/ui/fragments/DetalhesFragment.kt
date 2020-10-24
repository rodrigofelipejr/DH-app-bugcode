package br.com.house.digital.bugcode.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.`interface`.IContractMainActivity
import br.com.house.digital.bugcode.helper.ToastUtils

class DetalhesFragment : Fragment() {
    private var message = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ToastUtils.toastLong(message, context!!)
        return inflater.inflate(R.layout.fragment_detalhes, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("key")?.let {
            message = it
        }
    }

    companion object {
        fun newInstance(message: String) = DetalhesFragment().apply {
            arguments = Bundle().apply {
                putString("key", message)
            }
        }
    }
}