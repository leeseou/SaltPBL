package com.seeun.salt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import java.util.*

class datePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date_picker)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val vdateenter : Button = findViewById(R.id.vDateEnter)

        vdateenter.setOnClickListener{
            val intent = Intent(this,AddAccountBookActivity ::class.java)
            intent.putExtra("year",year)
            intent.putExtra("month",month)
            intent.putExtra("day of month",dayOfMonth)
            startActivity(intent)
        }

    }
}