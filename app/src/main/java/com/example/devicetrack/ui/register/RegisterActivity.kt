package com.example.devicetrack.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devicetrack.databinding.ActivityRegisterBinding
import com.example.devicetrack.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botó de registre
        binding.btnRegister.setOnClickListener {
            registerUser()
        }

        // Configurar el TextView per anar a la pantalla de login
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Configurar el botó de contrasenya oblidada
        binding.btnForgotPassword.setOnClickListener {
            // Aquí pots afegir la funcionalitat per recuperar la contrasenya
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUser() {
        val username = binding.username.editText?.text.toString().trim()
        val email = binding.email.editText?.text.toString().trim()
        val password = binding.password.editText?.text.toString().trim()
        val confirmPassword = binding.confirmPassword.editText?.text.toString().trim()

        if (username.isEmpty()) {
            binding.username.error = "Please enter username"
            binding.username.requestFocus()
            return
        }

        if (email.isEmpty()) {
            binding.email.error = "Please enter email"
            binding.email.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding.password.error = "Please enter password"
            binding.password.requestFocus()
            return
        }

        if (confirmPassword.isEmpty()) {
            binding.confirmPassword.error = "Please confirm your password"
            binding.confirmPassword.requestFocus()
            return
        }

        if (password != confirmPassword) {
            binding.confirmPassword.error = "Passwords do not match"
            binding.confirmPassword.requestFocus()
            return
        }

        // Aquí pots afegir la lògica per registrar l'usuari, com ara una crida a la API
        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
    }
}
