package com.example.devicetrack.ui.forgotpassword


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.devicetrack.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botó de Done
        binding.btnDone.setOnClickListener {
            resetPassword()
        }

        // Configurar el botó de Cancel
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun resetPassword() {
        val email = binding.email.editText?.text.toString().trim()
        val newPassword = binding.newPassword.editText?.text.toString().trim()
        val confirmPassword = binding.confirmPassword.editText?.text.toString().trim()

        if (email.isEmpty()) {
            binding.email.error = "Please enter email or phone number"
            binding.email.requestFocus()
            return
        }

        if (newPassword.isEmpty()) {
            binding.newPassword.error = "Please enter new password"
            binding.newPassword.requestFocus()
            return
        }

        if (confirmPassword.isEmpty()) {
            binding.confirmPassword.error = "Please confirm your password"
            binding.confirmPassword.requestFocus()
            return
        }

        if (newPassword != confirmPassword) {
            binding.confirmPassword.error = "Passwords do not match"
            binding.confirmPassword.requestFocus()
            return
        }

        // Aquí pots afegir la lògica per canviar la contrasenya, com ara una crida a la API
        Toast.makeText(this, "Password Reset Successfully", Toast.LENGTH_SHORT).show()
    }
}
