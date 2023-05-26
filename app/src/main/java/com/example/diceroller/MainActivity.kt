package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/** Это действие позволяет пользователю бросить кости и просмотреть результат
 * на экране.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Бросайте кости и обновляйте экран с результатом.
     */
    private fun rollDice() {
        // Создайте первый объект Dice с 6 сторонами и бросьте его.
        val dice = Dice(6)
        val diceRoll = dice.roll()


        // Обновите экран с помощью броска костей
        val resultTextView = findViewById<TextView>(R.id.textView)
        resultTextView.text = diceRoll.toString()


    }
}

/**
 * Класс для создания объекта с фиксированным числом граней.
 */
class Dice(private val numSides: Int) {

    /**
     * Сделайте случайный бросок кубика и верните результат.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}