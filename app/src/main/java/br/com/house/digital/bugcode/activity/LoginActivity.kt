package br.com.house.digital.bugcode.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.domain.Usuario
import br.com.house.digital.bugcode.helper.ViewUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_bottom_login.*
import java.lang.Integer.hashCode

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()
    }

    override fun onStart() {
        super.onStart()
        constraintLayout_login.setMinHeight(ViewUtils.minHeightViewNoActionBar(this))
    }

    fun setListeners() {
        text_cadastro.setOnClickListener {
            val intent = Intent(this, LoginCadastroActivity::class.java)
            intent.putExtra("usuario", userData())

            startActivity(intent)
        }

        button_login.setOnClickListener {
            Snackbar.make(scrollView_login, "Senha invalida", Snackbar.LENGTH_LONG)
                .setAction("OK", View.OnClickListener {})
                .show()
        }
    }

    fun userData(): Usuario =
        Usuario(1, textInputEdit_name.text.toString(), textInputEdit_password.text.toString())

}