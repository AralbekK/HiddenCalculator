package com.example.hiddencalculator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CalculatorActivity : Activity() {  // Используем Activity вместо AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // Найти элементы интерфейса
        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonSendResult: Button = findViewById(R.id.buttonSendResult)

        // Обработчики кнопок операций
        buttonAdd.setOnClickListener {
            val result = calculate(editTextNumber1.text.toString(), editTextNumber2.text.toString(), "add")
            transferResult(result)
        }

        buttonSubtract.setOnClickListener {
            val result = calculate(editTextNumber1.text.toString(), editTextNumber2.text.toString(), "subtract")
            transferResult(result)
        }

        buttonMultiply.setOnClickListener {
            val result = calculate(editTextNumber1.text.toString(), editTextNumber2.text.toString(), "multiply")
            transferResult(result)
        }

        buttonDivide.setOnClickListener {
            val result = calculate(editTextNumber1.text.toString(), editTextNumber2.text.toString(), "divide")
            transferResult(result)
        }

        // Обработчик кнопки передачи данных
        buttonSendResult.setOnClickListener {
            val result = editTextNumber1.text.toString()
            transferResult(result)
        }
    }

    // Функция для выполнения вычислений
    private fun calculate(number1: String, number2: String, operation: String): String {
        val num1 = number1.toDoubleOrNull() ?: 0.0
        val num2 = number2.toDoubleOrNull() ?: 0.0
        if (operation == "add") {
            return (num1 + num2).toString()
        } else if (operation == "subtract") {
            return (num1 - num2).toString()
        } else if (operation == "multiply") {
            return (num1 * num2).toString()
        } else if (operation == "divide") {
            return if (num2 != 0.0) (num1 / num2).toString() else "Error"
        } else {
            return "Error"
        }
    }

    // Функция для передачи результата в MainActivity
    private fun transferResult(result: String) {
        val intent = Intent()
        intent.putExtra("result", result)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
