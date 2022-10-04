package com.seeun.salt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goAccountButton = findViewById<Button>(R.id.goAccountButton)
        goAccountButton.setOnClickListener {
            val intent = Intent(this, AddAccountBookActivity::class.java)
            startActivity(intent)
        }
    }
}