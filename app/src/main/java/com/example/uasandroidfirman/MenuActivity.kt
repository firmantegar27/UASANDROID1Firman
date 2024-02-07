package com.example.uasandroidfirman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uasandroidfirman.databinding.ActivityMenuBinding
import com.example.uasandroidfirman.databinding.ActivityRoomBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.cvRoomDB.setOnClickListener {
            startActivity(Intent(this, RoomActivity::class.java))
        }

        binding.cvCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}