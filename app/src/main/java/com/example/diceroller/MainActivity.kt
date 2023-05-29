package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rollDice()
    }

    /**
     * Бросить кости и обновить экран с результатом.
     */
    private fun rollDice() {
        // Создайте первый объект Dice с 6 сторонами и бросьте его.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Создайте второй объект Dice с 6 сторонами и бросьте его.
        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()

        // Найти ImageView в макете
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Определить, какой идентификатор ресурса для рисования использовать на основе броска кубиков.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Обновляем ImageView с правильным идентификатором ресурса для рисования
        diceImage.setImageResource(drawableResource)
        // Обновить описание содержимого
        diceImage.contentDescription = diceRoll.toString()

        // Найти ImageView в макете
        val diceImageTwo: ImageView = findViewById(R.id.imageView2)
        // Определить, какой идентификатор ресурса для рисования использовать на основе броска кубиков.
        // Обновить описание содержимого
        when (diceRollTwo) {
            1 -> diceImageTwo.setImageResource(R.drawable.dice_1)
            2 -> diceImageTwo.setImageResource(R.drawable.dice_2)
            3 -> diceImageTwo.setImageResource(R.drawable.dice_3)
            4 -> diceImageTwo.setImageResource(R.drawable.dice_4)
            5 -> diceImageTwo.setImageResource(R.drawable.dice_5)
            6 -> diceImageTwo.setImageResource(R.drawable.dice_6)
        }
        // Обновить описание содержимого
        diceImageTwo.contentDescription = diceRoll.toString()
    }

    /**
     * Класс для создания объекта с фиксированным числом граней.
     */
    class Dice(private val numSides: Int) {

        /**
         * Сделайть случайный бросок кубика и вернуть результат.
         */
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}