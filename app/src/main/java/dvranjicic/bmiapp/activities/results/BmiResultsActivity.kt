package dvranjicic.bmiapp.activities.results

import android.content.Intent
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import dvranjicic.bmiapp.R
import dvranjicic.bmiapp.activities.base.BaseActivity
import dvranjicic.bmiapp.activities.setup.InputDataActivity
import dvranjicic.bmiapp.persistence.Repo
import kotlinx.android.synthetic.main.activity_bmi_results.*

class BmiResultsActivity : BaseActivity() {
    override fun getLayoutResourceId() = R.layout.activity_bmi_results

    override fun setupUi() {
        handleResultsDisplay()
        newCalculationButton.setOnClickListener { goBack() }
    }

    // shows appropriate image and text depending on the calculation result

    private fun handleResultsDisplay() {
        val result = findViewById<TextView>(R.id.calculationResult)
        result.text = Repo.getBmiValueAsString()

        val categoryTitle = findViewById<TextView>(R.id.resultCategoryName)
        val categoryDesc = findViewById<TextView>(R.id.resultCategoryDescription)
        val categoryImage = findViewById<ImageView>(R.id.resultCategoryImage)

        // this handling could be better

        if (Repo.bmi < 18.5) {
            categoryTitle.text = getString(R.string.underweightTitle)
            categoryTitle.setTextColor(Color.parseColor("#66ABE7"))
            categoryDesc.text = getString(R.string.underweightDescription)
            categoryImage.setImageResource(R.drawable.underweight)
        } else if (Repo.bmi >= 18.5 && Repo.bmi < 25) {
            categoryTitle.text = getString(R.string.normalTitle)
            categoryTitle.setTextColor(Color.parseColor("#67C241"))
            categoryDesc.text = getString(R.string.normalDescription)
            categoryImage.setImageResource(R.drawable.normal)
        } else if (Repo.bmi >= 25 && Repo.bmi < 30) {
            categoryTitle.text = getString(R.string.overweightTitle)
            categoryTitle.setTextColor(Color.parseColor("#C16F2D"))
            categoryDesc.text = getString(R.string.overweightDescription)
            categoryImage.setImageResource(R.drawable.overweight)
        } else {
            categoryTitle.text = getString(R.string.obeseTitle)
            categoryTitle.setTextColor(Color.parseColor("#BC2D2C"))
            categoryDesc.text = getString(R.string.obeseDescription)
            categoryImage.setImageResource(R.drawable.obese)
        }
    }

    override fun onBackPressed() {
        goBack()
    }

    // clears the repo and opens the data input activity

    private fun goBack() {
        Repo.clearData()
        startActivity(Intent(this, InputDataActivity::class.java))
    }
}