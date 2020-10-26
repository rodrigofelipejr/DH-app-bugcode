package br.com.house.digital.mywallet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.house.digital.mywallet.R
import br.com.house.digital.mywallet.helper.ToastUtils.snackbarLong
import kotlinx.android.synthetic.main.activity_login_cadastro.*
import kotlinx.android.synthetic.main.layout_bottom_login_cadastro.*
import kotlinx.android.synthetic.main.layout_toolbar_login.*

class LoginCadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_cadastro)

        setListeners()
    }

    fun setListeners() {
        button_cadastrar_login.setOnClickListener {
            when {
                textInputEdit_password.text.toString() == textInputEdit_confirm_password.text.toString() -> {
                    Toast.makeText(applicationContext, "Teste", Toast.LENGTH_SHORT).show();
                    snackbarLong(scrollView_login_cadastro, "Cadastro finalizado!")
                }
                else -> {
                    snackbarLong(scrollView_login_cadastro, "Senhas não coincidem!")
                    textInputEdit_password.setError("Senhas precisam ser iguais")
                    textInputEdit_confirm_password.setError("Senhas precisam ser iguais")
                }
            }
        }

        toolbar_login.setNavigationOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        toolbar_login.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.sobre -> {
                    Toast.makeText(applicationContext, "SOBRE", Toast.LENGTH_SHORT).show();
                    // Handle favorite icon press
                    true
                }
                else -> false
            }
        }
    }
}