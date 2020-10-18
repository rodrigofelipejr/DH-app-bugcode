package br.com.house.digital.bugcode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.house.digital.bugcode.R
import br.com.house.digital.bugcode.helper.ViewUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        constraintLayout_login.setMinHeight(ViewUtils.minHeightViewNoActionBar(this))
    }
}