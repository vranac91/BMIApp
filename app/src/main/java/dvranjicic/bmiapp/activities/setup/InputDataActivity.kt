package dvranjicic.bmiapp.activities.setup

import android.content.Intent
import android.text.TextUtils.isEmpty
import dvranjicic.bmiapp.R
import dvranjicic.bmiapp.activities.results.BmiResultsActivity
import dvranjicic.bmiapp.activities.base.BaseActivity
import dvranjicic.bmiapp.extensions.showToast
import dvranjicic.bmiapp.persistence.Repo
import kotlinx.android.synthetic.main.activity_input_data.*

class InputDataActivity : BaseActivity() {
    companion object {
        const val INPUT_DATA_ID = "Input Repo"
    }

    override fun getLayoutResourceId() = R.layout.activity_input_data

    override fun setupUi() {
        calculateButton.setOnClickListener { checkInput() }
    }

    // checks if the input is empty or the values are outside required boundaries
    // if the values are OK, saves them to the repo and opens the results activity

    fun checkInput() {
        if (isWeightEmpty()) {
            showToast(getString(R.string.emptyWeight))
            return
        }

        if (isHeightEmpty()) {
            showToast(getString(R.string.emptyHeight))
            return
        }

        val heightInput = heightInputField.text.trim().toString().toDouble()
        val weightInput = weightInputField.text.trim().toString().toDouble()

        if (weightInput <= 0 || weightInput > 350) {
            showToast(getString(R.string.wrongWeight))
            return
        }

        if (heightInput <= 0 || heightInput > 2.5) {
            showToast(getString(R.string.wrongHeight))
            return
        }

        Repo.calculateBmi(heightInput, weightInput)
        goToResults()
    }

    private fun isWeightEmpty() = isEmpty(weightInputField.text)
    private fun isHeightEmpty() = isEmpty(heightInputField.text)

    private fun goToResults() {
        startActivity(Intent(this, BmiResultsActivity::class.java))
    }

}
