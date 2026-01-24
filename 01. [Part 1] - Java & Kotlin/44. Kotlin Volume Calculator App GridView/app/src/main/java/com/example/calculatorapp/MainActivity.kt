package com.example.calculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridView: GridView =findViewById(R.id.gridView)
        val shape1:Shape= Shape(R.drawable.cube,"Cube")
        val shape2:Shape= Shape(R.drawable.cylinder,"Cylinder")
        val shape3:Shape=Shape(R.drawable.prism,"Prism")
        val shape4:Shape= Shape(R.drawable.sphere,"Sphere")
        val gridItems=listOf<Shape>(
            shape1,shape2,shape3,shape4)
        val myAdapter=MyCustomAdaptor(this,gridItems)
        gridView.adapter=myAdapter

        gridView.setOnItemClickListener { _, _,position,_ ->
            val clickedItem=myAdapter.getItem(position)
            if(clickedItem?.title.equals("Sphere"))
            {
                val intent=Intent(this,SphereActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}