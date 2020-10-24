package br.com.house.digital.bugcode.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.domain.Usuario
import br.com.house.digital.bugcode.helper.ViewUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_bottom_login.*

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
            startActivity(Intent(this, LoginCadastroActivity::class.java))
        }

        button_login.setOnClickListener {
            if (edit_name.text.toString() == "" && edit_password.text.toString() == "") {
                Snackbar.make(scrollView_login, "Senha invalida", Snackbar.LENGTH_LONG)
                    .setAction("OK", View.OnClickListener {})
                    .show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", userData())
                startActivity(intent)
            }
        }
    }

    fun userData(): Usuario =
        Usuario(1, edit_name.text.toString(), edit_password.text.toString())
}