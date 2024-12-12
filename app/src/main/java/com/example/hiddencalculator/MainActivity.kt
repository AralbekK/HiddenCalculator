package com.example.hiddencalculator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Найти элементы интерфейса
        val buttonCalculator: Button = findViewById(R.id.buttonCalculator)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val buttonExit: Button = findViewById(R.id.buttonExit)

        // Обработчик кнопки перехода на экран калькулятора
        buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivityForResult(intent, 1)
        }

        // Обработчик кнопки выхода
        buttonExit.setOnClickListener {
            Toast.makeText(this, "с божьей помощью", Toast.LENGTH_SHORT).show()
            // Завершение активности после отображения Toast сообщения
            finish()
        }
    }

    // Метод для получения результата от активности калькулятора
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val result = data?.getStringExtra("result")
            val resultTextView: TextView = findViewById(R.id.resultTextView)
            resultTextView.text = result
        }
    }
}
