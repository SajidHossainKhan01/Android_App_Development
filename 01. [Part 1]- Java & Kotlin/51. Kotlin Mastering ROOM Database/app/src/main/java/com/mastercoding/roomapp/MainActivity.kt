package com.mastercoding.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Initialize the widget
    lateinit var itemName: EditText
    lateinit var itemPrice: EditText
    lateinit var itemQuantity: EditText
    lateinit var dbRecordsText: TextView
    lateinit var saveBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemName = findViewById(R.id.editText1)
        itemPrice = findViewById(R.id.editText2)
        itemQuantity = findViewById(R.id.editText3)
        dbRecordsText = findViewById(R.id.textView3)
        saveBtn = findViewById(R.id.saveItemBtn)


        saveBtn.setOnClickListener {
            insertItem()
        }


        displayAllRecords()


    }

    fun insertItem(){

        // Getting the text from EditTexts
        val name = itemName.text.toString()
        val price = itemPrice.text.toString()
        val quantity = itemQuantity.text.toString()

        // Converting Strings to Int and Double
        val intPrice = price.toDouble()
        val intQuantity = quantity.toInt()

        // Instance of the Database
        val myDB = MyDB.getDatabase(applicationContext)

        // Instance of DAO
        val myDAO = myDB.itemDAO()


        // Inserting data into Database
        var myItem: Item = Item(0,name,intPrice,intQuantity)

        CoroutineScope(Dispatchers.IO).launch {
            myDAO.insertItem(myItem)

        }



    }

    fun displayAllRecords(){

        // Instance of the Database
        val myDB = MyDB.getDatabase(applicationContext)

        // Instance of DAO
        val myDAO = myDB.itemDAO()

        myDAO.getAllItemsInDB().observe(this, Observer {
            var result = ""

            for (item in it){
                result = it.joinToString("\n")

            }
            dbRecordsText.text = result

        })

    }


}