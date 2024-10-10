package br.unisanta.mvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mvvm.R
import br.unisanta.mvvm.databinding.ActivityLoginBinding // Importar o binding correto
import br.unisanta.mvvm.model.Usuario
import br.unisanta.mvvm.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding // Declaração do binding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // Inicializa o binding
        setContentView(binding.root) // Define o layout usando o binding

        // Configurar os cliques dos botões
        binding.btnEntrar.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()
            val usuario = Usuario(email, senha)
            val resultado = viewModel.entrar(usuario)
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()

            // Navegar para a lista de usuários se o login for bem-sucedido
            if (resultado == "Login realizado com sucesso.") {
                val intent = Intent(this, UserListActivity::class.java)
                startActivity(intent)
                finish() // Fecha a LoginActivity
            }
        }

        binding.btnCadastrar.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()
            val usuario = Usuario(email, senha)
            val resultado = viewModel.cadastrar(usuario)
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
        }
    }
}