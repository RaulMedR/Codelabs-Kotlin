package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice(){
        val randomInt = (1..6).random()
        //Toast.makeText(this, "button clicked",
        //    Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)
        try {
            if (Integer.parseInt(resultText.text.toString()) < 6) {
                resultText.setText((Integer.parseInt(resultText.text.toString()) + 1).toString())
            }
        } catch(err: NumberFormatException){
            resultText.setText("1")
        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.setText("0")
    }
}