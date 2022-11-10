package com.seeun.salt

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    //로그인&회원가입
    val TAG: String = "login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼
        btn_login.setOnClickListener {
            //editText로부터 입력된 값 받아오기
            var id = edit_id.text.toString()
            var pw = edit_pw.text.toString()

            //쉐어드로부터 저장된 id, pw 가져오기
            val sharedPreferences = getSharedPreferences("file name", Context.MODE_PRIVATE)
            val savedId = sharedPreferences.getString("id", "")
            val savedPw = sharedPreferences.getString("pw", "")

            //유저가 입력한 id, pw 값과 쉐어드로 불러온 id, pw값 비교
            if(id == savedId && pw == savedPw) {
                //로그인 성공 다이얼로그
                dialog("success")

                //가계부화면으로 이동
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                //로그인 실패 다이얼로그
                dialog("fail")
            }
        }

        //회원가입 버튼
        btn_register.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        //아이디 찾기 버튼
        text_findID.setOnClickListener {
            Toast.makeText(this, "아이디 찾기", Toast.LENGTH_SHORT).show()
        }

        //비밀번호 찾기 버튼
        text_findPW.setOnClickListener {
            Toast.makeText(this, "비밀번호 찾기", Toast.LENGTH_SHORT).show()
        }

    }

    //다이얼로그 메소드
    private fun dialog(type: String) {
        var dialog = AlertDialog.Builder(this)

        if(type.equals("success")){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공")
        } else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listenr = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "")
                }
            }
        }
        dialog.setPositiveButton("확인", dialog_listenr)
        dialog.show()
    }

}