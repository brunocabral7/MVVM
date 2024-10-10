package br.unisanta.mvvm.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mvvm.adapter.UsuarioAdapter
import br.unisanta.mvvm.databinding.ActivityUserListBinding
import br.unisanta.mvvm.model.Usuario
import br.unisanta.mvvm.viewmodel.LoginViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pegaUsuario()

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun pegaUsuario(){
        val usuarios = intent.getSerializableExtra("usuarios") as? ArrayList<Usuario>
        usuarios?.let {
            val adapter = UsuarioAdapter(this, usuarios.toList())
            binding.listViewUsuarios.adapter = adapter
        }

    }
}