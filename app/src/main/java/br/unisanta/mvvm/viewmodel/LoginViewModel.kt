package br.unisanta.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.mvvm.model.Usuario

class LoginViewModel : ViewModel() {
    private val usuarios = mutableListOf<Usuario>()

    fun entrar(user: Usuario): String {
        val usuario = usuarios.find { it.email == user.email }

        if (usuario == null) {
            return "Usuário não encontrado!"
        }
        if (usuario.bloqueado) {
            return "Usuário bloqueado. Acesso negado!"
        }

        return if (usuario.senha == user.senha) {
            usuario.tentativas = 0
            "Login realizado com sucesso."
        } else {
            usuario.tentativas++
            if (usuario.tentativas >= 3) {
                usuario.bloqueado = true
                "Usuário bloqueado após 3 tentativas inválidas!"
            } else {
                "Senha inválida! Tentativas restantes: ${3 - usuario.tentativas}."
            }
        }
    }

    fun cadastrar(user: Usuario): String {
        if (usuarios.any { it.email == user.email }) {
            return "Usuário já cadastrado!"
        }
        usuarios.add(user)
        return "Cadastrado com sucesso!"
    }

    fun getUsuarios(): List<Usuario> {
        return usuarios
    }
}