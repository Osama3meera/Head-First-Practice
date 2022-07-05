package com.example.head_first_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findJuice = findViewById<Button>(R.id.findJuice)

        findJuice.setOnClickListener {

            val juiceColor = findViewById<Spinner>(R.id.juiceColor)
            val color = juiceColor.selectedItem
            val juiceList = getJuice(color.toString())
            val juices = juiceList.reduce { str, item -> str + '\n' + item }
            val brand = findViewById<TextView>(R.id.brands)
            brand.text = juices
        }

    }

    private fun getJuice(color: String): List<String> {
        return when (color) {
            "Orange" -> listOf("Rani - Orange", "Original - Orange", "Raugh - Orange")
            "Kiwi" -> listOf("Rani - Kiwi", "Original - Kiwi", "Raugh - Kiwi")
            "Strawberry" -> listOf(
                "Rani - Strawberry",
                "Original - Strawberry",
                "Raugh - Strawberry"
            )
            else -> listOf("Milk Shake", "Kiwi and Strawberry", "Lemon and Mint")
        }
    }
}