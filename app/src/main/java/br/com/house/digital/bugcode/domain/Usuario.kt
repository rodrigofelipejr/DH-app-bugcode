package br.com.house.digital.bugcode.domain

import java.io.Serializable

class Usuario(var id: Int, var userName: String, var password: String) : Serializable {
    override fun toString(): String {
        return "User -> id: $id - userName: $userName - password $password"
    }
}