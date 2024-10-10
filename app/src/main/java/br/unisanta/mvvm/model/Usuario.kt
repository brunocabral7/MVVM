package br.unisanta.mvvm.model

import java.io.Serializable

data class Usuario(
    val email:String,
    val senha:String,
    var bloqueado: Boolean = false,
    var tentativas: Int = 0
): Serializable

