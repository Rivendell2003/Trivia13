package com.example.triviaactivity13

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val rgAnswers: RadioGroup = findViewById(R.id.rg_answers)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        val userName = intent.getStringExtra("USER_NAME")
        tvQuestion.text = "Hola $userName! ¿Conoces esta imagen?"

        btnSubmit.setOnClickListener {
            val selectedOption = rgAnswers.checkedRadioButtonId
            if (selectedOption == -1) {
                Toast.makeText(this, "Por favor, selecciona una respuesta", Toast.LENGTH_SHORT).show()
            } else {
                val message = if (selectedOption == R.id.rb_yes) {
                    "¡Bien hecho, $userName!"
                } else {
                    "Intenta de nuevo, $userName."
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
