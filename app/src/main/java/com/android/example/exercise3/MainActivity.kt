package com.android.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculatePremium()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }

    }

    private fun calculatePremium() {
        val age = findViewById<Spinner>(R.id.spinnerAge)
        val gender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val isSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val insuranceText = findViewById<TextView>(R.id.textViewPremium)
        var totalInsurance = 0
        var premiumFee = 0
        var genderFee = 0
        var smokerFee = 0

        if (age.selectedItemPosition == 0) {
            premiumFee = 60
        } else if (age.selectedItemPosition == 1) {
            premiumFee = 70
            if (gender.checkedRadioButtonId != -1) {
                val checked = findViewById<RadioButton>(gender.checkedRadioButtonId)
                if (checked.text == "Male") {
                    genderFee = 50
                }
            }
            if (isSmoker.isChecked) {
                smokerFee = 100
            }
        } else if (age.selectedItemPosition == 2) {
            premiumFee = 90
            if (gender.checkedRadioButtonId != -1) {
                val checked = findViewById<RadioButton>(gender.checkedRadioButtonId)
                if (checked.text == "Male") {
                    genderFee = 100
                }
            }
            if (isSmoker.isChecked) {
                smokerFee = 150
            }
        } else if (age.selectedItemPosition == 3) {
            premiumFee = 120
            if (gender.checkedRadioButtonId != -1) {
                val checked = findViewById<RadioButton>(gender.checkedRadioButtonId)
                if (checked.text == "Male") {
                    genderFee = 150
                }
            }
            if (isSmoker.isChecked) {
                smokerFee = 200
            }
        } else if (age.selectedItemPosition == 4) {
            premiumFee = 150
            if (gender.checkedRadioButtonId != -1) {
                val checked = findViewById<RadioButton>(gender.checkedRadioButtonId)
                if (checked.text == "Male") {
                    genderFee = 200
                }
            }
            if (isSmoker.isChecked) {
                smokerFee = 250
            }
        } else if (age.selectedItemPosition == 5) {
            premiumFee = 150
            if (gender.checkedRadioButtonId != -1) {
                val checked = findViewById<RadioButton>(gender.checkedRadioButtonId)
                if (checked.text == "Male") {
                    genderFee = 200
                }
            }
            if (isSmoker.isChecked) {
                smokerFee = 300
            }
        }

        totalInsurance += premiumFee + genderFee + smokerFee
        insuranceText.text =
            (resources.getString(R.string.insurance_premium) + " RM " + totalInsurance.toString())
    }

    private fun reset() {
        val age = findViewById<Spinner>(R.id.spinnerAge)
        val gender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val isSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val insuranceText = findViewById<TextView>(R.id.textViewPremium)

        age.setSelection(0)
        gender.clearCheck()
        isSmoker.isChecked = false
        insuranceText.text = resources.getString(R.string.insurance_premium)
    }
}
