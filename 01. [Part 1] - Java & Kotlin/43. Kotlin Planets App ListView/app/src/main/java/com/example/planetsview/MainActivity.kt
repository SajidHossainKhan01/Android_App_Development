package com.example.planetsview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val listView:ListView = findViewById(R.id.listView)

        val planet1= Planet("Mercury","0",R.drawable.mercury)
        val planet2= Planet("Venus","0",R.drawable.venus)
        val planet3= Planet("Earth","1 Moon",R.drawable.earth)
        val planet4= Planet("Mars","2 Moons",R.drawable.mars)
        val planet5 = Planet("Jupiter","79 moons",R.drawable.jupiter)


        var planetsList = ArrayList<Planet>()
        planetsList.add(planet1)
        planetsList.add(planet2)
        planetsList.add(planet3)
        planetsList.add(planet4)
        planetsList.add(planet5)

        var myAdapter = MyCustomAdapter(this,planetsList)
        listView.adapter = myAdapter
    }
}