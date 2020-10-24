package br.com.house.digital.bugcode.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.`interface`.IContractMainActivity
import br.com.house.digital.bugcode.domain.Usuario
import br.com.house.digital.bugcode.ui.fragments.EntradasFragment
import br.com.house.digital.bugcode.ui.fragments.GastosFragment
import br.com.house.digital.bugcode.ui.fragments.HomeFragment
import br.com.house.digital.bugcode.helper.FragmentsUtils
import br.com.house.digital.bugcode.helper.ToastUtils.toastLong
import br.com.house.digital.bugcode.ui.fragments.DetalhesFragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, IContractMainActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialFragment()
        setListeners()
        getUserData()
        toolbar_main.setTitle(R.string.title_toolbar)

        setSupportActionBar(toolbar_main)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        toolbar_main.setNavigationOnClickListener {
//
//        }
    }

    override fun onClick(view: View) {
        setColorDefault()
        when (view.id) {
            R.id.button_home -> {
                setColorActive(button_home as MaterialButton)
                FragmentsUtils.addFragmentToActivity(
                    supportFragmentManager,
                    HomeFragment.newInstance(),
                    R.id.frameLayout_main
                )
            }
            R.id.button_entradas -> {
                setColorActive(button_entradas as MaterialButton)
                FragmentsUtils.addFragmentToActivity(
                    supportFragmentManager,
                    EntradasFragment.newInstance(),
                    R.id.frameLayout_main
                )
            }
            R.id.button_gastos -> {
                setColorActive(button_gastos as MaterialButton)
                FragmentsUtils.addFragmentToActivity(
                    supportFragmentManager,
                    GastosFragment.newInstance(),
                    R.id.frameLayout_main
                )
            }
        }
    }

    private fun setListeners() {
        button_home.setOnClickListener(this)
        button_entradas.setOnClickListener(this)
        button_gastos.setOnClickListener(this)
    }

    private fun initialFragment() {
        FragmentsUtils.addFragmentToActivity(
            supportFragmentManager,
            HomeFragment.newInstance(),
            R.id.frameLayout_main
        )
    }

    private fun setColorDefault() {
        button_home.setTextAppearance(R.style.Theme_Custom_Button_Tab_TextButton_Icon)
        button_home.setIconTintResource(R.color.white)

        button_entradas.setTextAppearance(R.style.Theme_Custom_Button_Tab_TextButton_Icon)
        button_entradas.setIconTintResource(R.color.white)

        button_gastos.setTextAppearance(R.style.Theme_Custom_Button_Tab_TextButton_Icon)
        button_gastos.setIconTintResource(R.color.white)
    }

    private fun setColorActive(button: MaterialButton) {
        button.setTextAppearance(R.style.Theme_Custom_Button_Tab_TextButton_Icon_Active)
        button.setIconTintResource(R.color.purple_700)
    }

    private fun getUserData() {
        var usuario = intent.getSerializableExtra("user") as? Usuario
    }

    override fun irParaDetalhes(message: String) {
        FragmentsUtils.addFragmentToActivity(
            supportFragmentManager,
            DetalhesFragment.newInstance(message),
            R.id.frameLayout_main
        )
    }

    override fun showMassage(message: String) {
        toastLong(message, applicationContext)
    }
}