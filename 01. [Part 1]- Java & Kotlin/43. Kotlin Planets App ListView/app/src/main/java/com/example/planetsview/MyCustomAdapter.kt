package com.example.planetsview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MyCustomAdapter(val context:Context,val planets:List<Planet>):BaseAdapter() {
    override fun getCount(): Int {
        return planets.size
    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
       //returns a unique identifier for the item at specified position.
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Returns a View that displays the data at specified position in the List.
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View

        if(convertView==null)
        {
            view = inflater.inflate(R.layout.item_list_layout,parent, false)

        }else
        {
            view = convertView
        }
        //Bind data to the View
        val item = getItem(position) as Planet
        val titleTextView = view.findViewById<TextView>(R.id.planet_name)
        val moonCountTextView = view.findViewById<TextView>(R.id.moon_count_text)
        val moon_image = view.findViewById<ImageView>(R.id.imageView)

        titleTextView.text = item.title
        moonCountTextView.text = item.moonCount
        moon_image.setImageResource(item.imagePlanet)
        return view
    }
}