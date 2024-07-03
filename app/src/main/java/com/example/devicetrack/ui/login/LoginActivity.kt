package com.example.devicetrack.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.devicetrack.databinding.ActivityLoginBinding
import com.example.devicetrack.ui.forgotpassword.ForgotPasswordActivity
import com.example.devicetrack.MainActivity
import com.example.devicetrack.data.UsuariosRepositorio
import com.example.devicetrack.data.model.Usuario
import com.example.devicetrack.ui.register.RegisterActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    val usuarioRepo = UsuariosRepositorio()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón de login
        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        // Configurar el TextView para ir a la pantalla de registro
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Configurar el botón de contraseña olvidada
        binding.btnForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun loginUser() {
        val emailOrNumber = binding.email.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()

        if (emailOrNumber.isEmpty()) {
            binding.email.error = "Please enter email or phone number"
            binding.email.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding.password.error = "Please enter password"
            binding.password.requestFocus()
            return
        }

        // Lanzar una coroutine para llamar a authenticate cuando se hace clic en el botón
        lifecycleScope.launch {
            val isAuthenticated : List<Usuario> = authenticate(emailOrNumber, password)
            if (isAuthenticated.isNotEmpty()) {
                saveUserLogin(isAuthenticated[0].id_usuario.toString())
                Toast.makeText(this@LoginActivity, "Login exitoso", Toast.LENGTH_SHORT).show()
                // Redirigir a la siguiente actividad
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun authenticate(username: String, password: String): List<Usuario> {
        val user = usuarioRepo.getUsuarioLogin(username, password)
        Log.d("Auth", "User: $user")
        //val userr:Usuario =  Usuario(
        //    id_usuario = 1,
          //  nombre = "Juan Perez",
            //telefono = 123456789,
        //    email = "juan.perez@example.com",
          //  contrasenya = "password123"
        //)
        //val user:List<Usuario> = listOf(userr)
        return user
    }

    private fun saveUserLogin(idUser: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("idUser", idUser)
        editor.apply()
    }
}
