package com.example.colorviewmy

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(findViewById<TextView>(R.id.box_one_text) ,
            findViewById<TextView>(R.id.box_two_text), findViewById<TextView>(R.id.box_three_text),
            findViewById<TextView>(R.id.box_four_text), findViewById<View>(R.id.constraint_layout),
            findViewById<Button>(R.id.red_button), findViewById<Button>(R.id.yellow_button),
            findViewById<Button>(R.id.green_button))

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View){
        val changingViewColor: TextView

        when (view.id) {

            // Using class colors
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Using resource colors
            R.id.box_three_text -> view.setBackgroundColor(ContextCompat.getColor(applicationContext,android.R.color.holo_blue_bright))
            R.id.box_four_text -> view.setBackgroundColor(ContextCompat.getColor(applicationContext,android.R.color.holo_green_dark))

            R.id.red_button -> {
                changingViewColor = findViewById(R.id.box_two_text)
                changingViewColor.setBackgroundResource(R.color.my_red)
            }
            R.id.yellow_button -> {
                changingViewColor = findViewById(R.id.box_three_text)
                changingViewColor.setBackgroundResource(R.color.my_yellow)
            }
            R.id.green_button -> {
                changingViewColor = findViewById(R.id.box_four_text)
                changingViewColor.setBackgroundResource(R.color.my_green)
            }
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}