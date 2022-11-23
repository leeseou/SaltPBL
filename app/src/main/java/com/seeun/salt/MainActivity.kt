package com.seeun.salt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.seeun.salt.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_day.*

class MainActivity : AppCompatActivity() {

    // 프레그먼트 선언

    lateinit var binding: ActivityMainBinding

    companion object {

        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity - onCreate() called")

        binding = ActivityMainBinding.inflate(layoutInflater)
        // 레이아웃과 연결
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val bottomBar = binding.bnvMain

        bottomBar.setOnItemSelectedListener { item ->
            Log.d(TAG,"MainActivity - setOnItemSelectedListener() called")
            changeFragment(
                when (item.itemId) {
                    R.id.menu_home-> {
                        HomeFragment()
                    }
                    R.id.menu_account->{
                        AccountFragment()
                    }
                    R.id.menu_mypage-> {
                        MypageFragment()
                    }
                    R.id.menu_RA->{
                        RaFragment()
                    }
                    R.id.menu_report->{
                        ReportFragment()
                    }
                    else -> {
                        HomeFragment()
                    }
                }
            )
            true
        }
        bottomBar.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment)
            .commit()
    }


}






