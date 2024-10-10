package br.unisanta.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.unisanta.mvvm.model.Usuario

class UsuarioAdapter(context: Context, private val usuarios: List<Usuario>) :
    ArrayAdapter<Usuario>(context, 0, usuarios) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val usuario = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)

        val txtEmail = view.findViewById<TextView>(android.R.id.text1)
        val txtTentativas = view.findViewById<TextView>(android.R.id.text2)

        txtEmail.text = usuario?.email
        txtTentativas.text = "Tentativas: ${usuario?.tentativas}"

        return view
    }
}