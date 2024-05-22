package com.example.devicetrack.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devicetrack.databinding.ActivityLoginBinding
import com.example.devicetrack.ui.forgotpassword.ForgotPasswordActivity
import com.example.devicetrack.MainActivity
import com.example.devicetrack.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botó de login
        binding.btnLogin.setOnClickListener {
            loginUser()
        }

        // Configurar el TextView per anar a la pantalla de registre
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Configurar el botó de contrasenya oblidada
        binding.btnForgotPassword.setOnClickListener {
            // Aquí pots afegir la funcionalitat per recuperar la contrasenya
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun loginUser() {
        val email = binding.email.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()

        if (email.isEmpty()) {
            binding.email.error = "Please enter email or phone number"
            binding.email.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding.password.error = "Please enter password"
            binding.password.requestFocus()
            return
        }

        // Aquí pots afegir la lògica per iniciar sessió l'usuari, com ara una crida a la API
        Toast.makeText(this, "User Logged In Successfully", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}
