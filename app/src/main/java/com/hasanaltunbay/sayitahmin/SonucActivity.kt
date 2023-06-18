package com.hasanaltunbay.sayitahmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hasanaltunbay.sayitahmin.databinding.ActivityMainBinding
import com.hasanaltunbay.sayitahmin.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sonuc=intent.getBooleanExtra("sonuc",false)

        if (sonuc){
            binding.textViewSonuc.text="KAZANDINIZ"
            binding.imageViewSonuc.setImageResource(R.drawable.true_resim)

        }else{
            binding.textViewSonuc.text="KAYBETTİNİZ"
            binding.imageViewSonuc.setImageResource(R.drawable.false_resim)
        }



        binding.buttonTekrar.setOnClickListener {
            startActivity(Intent(this@SonucActivity,TahminActivity::class.java))
            finish()
        }
    }
}