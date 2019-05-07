package dvranjicic.bmiapp.persistence

import kotlin.math.pow

object Repo {
    // variables for keeping the value of height, weight and calculated BMI
    var height: Double = 0.0
    var weight: Double = 0.0
    var bmi: Double = 0.0

    // calculates BMI based on input values

    fun calculateBmi(heightInput: Double, weightInput: Double) {
        height = heightInput
        weight = weightInput
        bmi = (weight / height.pow(2))
    }

    // returns BMI rounded to 2 decimals as a string

    fun getBmiValueAsString() = "BMI Value: " + String.format("%.2f", bmi)

    // resets the height, weight and BMI variables values

    fun clearData() {
        height = 0.0
        weight = 0.0
        bmi = 0.0
    }
}