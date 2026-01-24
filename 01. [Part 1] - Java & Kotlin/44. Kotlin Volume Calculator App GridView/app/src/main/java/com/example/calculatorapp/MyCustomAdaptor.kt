package com.example.calculatorapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdaptor(private val context: Context, private val gridItems:List<Shape>):ArrayAdapter<Shape>(context,0,gridItems) {
    private class ViewHolder{
        lateinit var imageView: ImageView
        lateinit var textView: TextView
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        var itemView=convertView
        val holder:ViewHolder
        if(itemView==null){
            itemView=LayoutInflater.from(context).inflate(R.layout.grid_layout,parent,false)
            holder=ViewHolder()
            holder.imageView=itemView.findViewById(R.id.imageView)
            holder.textView=itemView.findViewById(R.id.textView)
            itemView.tag=holder
        }else{
            holder=itemView?.tag as ViewHolder
        }
        val currentItem=gridItems[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text=currentItem.title
        return itemView!!
    }
}