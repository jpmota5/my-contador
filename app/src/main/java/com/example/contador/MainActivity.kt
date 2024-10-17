package com.example.contador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterTextView = findViewById<TextView>(R.id.counterTextView)
        val increaseButton = findViewById<Button>(R.id.increaseButton)
        val decreaseButton = findViewById<Button>(R.id.decreaseButton)

        // Atualiza o texto da contagem
        fun updateCounterText() {
            counterTextView.text = counter.toString()
        }

        // Aumenta o contador
        increaseButton.setOnClickListener {
            counter++
            updateCounterText()
            if (counter > 0) {
                decreaseButton.isEnabled = true
            }
        }

        // Diminui o contador sem ir abaixo de 0
        decreaseButton.setOnClickListener {
            if (counter > 0) {
                counter--
                updateCounterText()
            }
            if (counter == 0) {
                decreaseButton.isEnabled = false
            }
        }

        // Inicialmente, desativa o botão de diminuir
        decreaseButton.isEnabled = false
    }
}