package com.seeun.salt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var LoginCheck: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goAccountButton.setOnClickListener {
            if (!LoginCheck){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                LoginCheck = true
            } else {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
            }
        }
    }
}