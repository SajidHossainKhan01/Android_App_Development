package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.compose.material3.Text

class SphereActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sphere)
        editText=findViewById(R.id.enter_radius)
        button=findViewById(R.id.button)
        textView=findViewById(R.id.result)
        button.setOnClickListener{
            val radius=editText.text.toString()
            val r=Integer.parseInt(radius)
            val volume=(4/3)*3.14159*r*r*r
            textView.text="Result:$volume"
        }
    }
}