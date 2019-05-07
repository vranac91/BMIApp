package dvranjicic.bmiapp.activities.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResourceId())
        setupUi()
    }

    abstract fun getLayoutResourceId() : Int
    abstract fun setupUi()
}