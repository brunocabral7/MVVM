package br.unisanta.mvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mvvm.R
import br.unisanta.mvvm.model.Usuario
import br.unisanta.mvvm.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        btnEntrar.setOnClickListener {
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()
            val usuario = Usuario(email, senha)
            val resultado = viewModel.entrar(usuario)
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, UserListActivity::class.java)
            val arrayList= ArrayList(viewModel.getUsuarios())
            intent.putExtra("usuarios",  arrayList)
            startActivity(intent)

        }

        btnCadastrar.setOnClickListener {
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()
            val usuario = Usuario(email, senha)
            val resultado = viewModel.cadastrar(usuario)
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
        }

    }
}