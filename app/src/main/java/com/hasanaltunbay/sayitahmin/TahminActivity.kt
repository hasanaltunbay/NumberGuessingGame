package com.hasanaltunbay.sayitahmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hasanaltunbay.sayitahmin.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {

    private var RasgeleSayi=0

    private var sayac=5



    private lateinit var binding: ActivityTahminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sonuc=intent.getStringExtra("deger")


         var sayi=sonuc.toString().toInt()

        RasgeleSayi= Random.nextInt(sayi)
        Log.e("Rasgele Sayi",RasgeleSayi.toString())

        binding.buttonTahmin.setOnClickListener {


            sayac= sayac - 1

            val tahmin=binding.editTextGirdi.text.toString().toInt()

            if (tahmin == RasgeleSayi){

                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }

            if (tahmin > RasgeleSayi){
                if (tahmin-RasgeleSayi<=5){
                    binding.textViewDetay.text="Çok Sıcak"
                }else{
                    binding.textViewDetay.text="Soğuk"
                }

                binding.textViewYardim.text="Azalt"
                binding.textViewKalanHak.text="Kalan Hak :$sayac"
            }

            if (tahmin < RasgeleSayi){
                if (RasgeleSayi-tahmin<=5){
                    binding.textViewDetay.text="Çok Sıcak"
                }
                else{
                    binding.textViewDetay.text="Soğuk"

                }
                binding.textViewYardim.text="Arttır"
                binding.textViewKalanHak.text="Kalan Hak :$sayac"

            }



            if (sayac==0){

                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)
            }

            binding.editTextGirdi.setText("")



        }
    }
}