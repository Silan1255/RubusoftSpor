package com.example.rubusoftspor

import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var list_of_items = arrayOf("Ayarlar", "Sporcular")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            list_of_items
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter.setNotifyOnChange(true)
        spinner.isClickable = false

        spinner.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        spinner.adapter = adapter
                    }
                }

                return v?.onTouchEvent(event) ?: true
            }
        })

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "Filtreleme yapmadınız.", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                (view as TextView).text = ""
                when(position){
                    0 -> {
                        //Ayarlar sayfasına yönlendirme
                        Toast.makeText(applicationContext, "Ayarlar", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        //Sporcular sayfasına yönlendirme
                        Toast.makeText(applicationContext, "Sporcular", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}