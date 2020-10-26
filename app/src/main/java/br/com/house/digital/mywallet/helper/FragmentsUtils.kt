package br.com.house.digital.mywallet.helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object FragmentsUtils {
    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(frameId, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }
}