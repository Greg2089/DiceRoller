package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generate_number() {
        val dice = MainActivity.Dice(6)
        val rollResult = dice.roll()
        assertTrue(
            "Значение rollResult не находится между 1 и 6", rollResult in 1..6
        )

    }
}