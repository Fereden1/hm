package com.example.frdntest

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.frdntest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Отслеживаем изменения в полях и валидируем
        binding.emailInput.doAfterTextChanged { validateInputs() }
        binding.passwordInput.doAfterTextChanged { validateInputs() }

        // Кнопка "Продолжить" — переход на третий экран
        binding.continueButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
            }
            startActivity(intent)
        }

        // Кнопка "Назад" — возвращение на MainActivity
        binding.button2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Изначально кнопка недоступна, валидируем
        validateInputs()
    }

    // Проверка валидности email и пароля
    private fun validateInputs() {
        val emailText = binding.emailInput.text.toString()
        val passwordText = binding.passwordInput.text.toString()

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
        val isPasswordValid = passwordText.length >= 8 &&
                passwordText.any { it.isDigit() } &&
                passwordText.any { it.isLowerCase() } &&
                passwordText.any { it.isUpperCase() }

        binding.continueButton.isEnabled = isEmailValid && isPasswordValid
    }
}
