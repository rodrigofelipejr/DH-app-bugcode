package br.com.house.digital.bugcode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.helper.ToastUtils.snackbarLong
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login_cadastro.*
import kotlinx.android.synthetic.main.layout_bottom_login_cadastro.*

class LoginCadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_cadastro)

        setListeners()
    }

    fun setListeners(){
        button_cadastrar_login.setOnClickListener{
            when{
                textInputEdit_password.text.toString() == textInputEdit_confirm_password.text.toString() -> {
                    Toast.makeText(applicationContext, "Teste", Toast.LENGTH_SHORT).show();
                    snackbarLong(scrollView_login_cadastro, "Cadastro finalizado!")
                }
                else -> {
                    snackbarLong(scrollView_login_cadastro, "Senhas não coincidem!")
                    //textInputEdit_password.setError("Senhas precisam ser iguais")
                    //textInputEdit_confirm_password.setError("Senhas precisam ser iguais")
                }
            }
        }
    }
}