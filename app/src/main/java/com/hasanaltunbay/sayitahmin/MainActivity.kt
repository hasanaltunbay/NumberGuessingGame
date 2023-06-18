package com.hasanaltunbay.sayitahmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hasanaltunbay.sayitahmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.buttonBasla.setOnClickListener {

            var degisken=binding.editTextGirilenSayi.text.toString()

            val intent = Intent(this@MainActivity,TahminActivity::class.java)
            intent.putExtra("deger",degisken)
            startActivity(intent)


        }

    }
}