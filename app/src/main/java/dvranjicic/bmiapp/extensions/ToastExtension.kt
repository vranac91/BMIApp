package dvranjicic.bmiapp.extensions

import android.content.Context
import android.widget.Toast

fun Context.showToast(input: String) = Toast.makeText(this, input, Toast.LENGTH_SHORT).show()