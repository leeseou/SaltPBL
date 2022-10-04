package com.seeun.salt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.seeun.salt.databinding.ActivityAddAccountBookBinding

class AddAccountBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account_book)

        val binding = ActivityAddAccountBookBinding.inflate(layoutInflater)

        val consumtionbutton: Button = findViewById(R.id.consumtionButton)
        val incomebutton: Button = findViewById(R.id.incomeButton)
        val transferbutton: Button = findViewById(R.id.transferButton)

        val daytext: TextView = findViewById(R.id.dayText)
        val amounttext: TextView = findViewById(R.id.amountText)
        val category: Button = findViewById(R.id.categoryButton)

        consumtionbutton.setOnClickListener {
            binding.incomeButton.isActivated = false
            binding.transferButton.isActivated = false
            // 버튼 눌렀을 때 색상 변경하기

        }

        incomebutton.setOnClickListener {

            binding.consumtionButton.isActivated = false
            binding.transferButton.isActivated = false
            // 버튼 눌렀을 때 색상 변경하기

        }

        transferbutton.setOnClickListener {
            binding.incomeButton.isActivated = false
            binding.consumtionButton.isActivated = false
            // 버튼 눌렀을 때 색상 변경하기

        }

        val year = intent.getStringExtra("year") // 현재 년도만 구하는 법 찾아보기
        val month = intent.getStringExtra("month")
        val dayofMonth = intent.getStringExtra("dayofMonth")

        val day = year + " - " + month + " - " + dayofMonth
        daytext.setText(day)
        //datepicker이 textView 터치하면 팝업 형식으로 나오도록!

    }
}