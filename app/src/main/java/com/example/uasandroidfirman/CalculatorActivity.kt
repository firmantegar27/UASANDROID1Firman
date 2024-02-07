package com.example.uasandroidfirman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uasandroidfirman.databinding.ActivityCalculatorBinding
import com.example.uasandroidfirman.databinding.ActivityMenuBinding

private lateinit var binding: ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPlus.setOnClickListener {

            val angka1 = binding.edtAngkaPertama.text.toString().trim().toIntOrNull()?:0
            val angka2 = binding.edtAngkaKedua.text.toString().trim().toIntOrNull()?:0

            val hasil = angka1 + angka2

            binding.tvHasil.setText("Hasilnya adalah " + hasil.toString())

        }

        binding.btnMin.setOnClickListener {

            val angka1 = binding.edtAngkaPertama.text.toString().trim().toIntOrNull()?:0
            val angka2 = binding.edtAngkaKedua.text.toString().trim().toIntOrNull()?:0

            val hasil = angka1 - angka2

            binding.tvHasil.setText("Hasilnya adalah " + hasil.toString())

        }

        binding.btnKali.setOnClickListener {

            val angka1 = binding.edtAngkaPertama.text.toString().trim().toIntOrNull()?:0
            val angka2 = binding.edtAngkaKedua.text.toString().trim().toIntOrNull()?:0

            val hasil = angka1 * angka2

            binding.tvHasil.setText("Hasilnya adalah " + hasil.toString())

        }

        binding.btnBagi.setOnClickListener {

            val angka1 = binding.edtAngkaPertama.text.toString().trim().toIntOrNull()?:0
            val angka2 = binding.edtAngkaKedua.text.toString().trim().toIntOrNull()?:0

            val hasil = angka1 / angka2

            binding.tvHasil.setText("Hasilnya adalah " + hasil.toString())

        }

        binding.btnHitung.setOnClickListener {

            val hargaJerukInput = binding.edtHargaAsli.text.toString().trim().toDoubleOrNull() ?: 0.0


            val diskonPersentaseInputText = binding.edtDiskon.text.toString().trim()
            val diskonPersentaseInput = if (diskonPersentaseInputText.endsWith('%')) {

                diskonPersentaseInputText.substring(0, diskonPersentaseInputText.length - 1).toDoubleOrNull() ?: 0.0
            } else {

                diskonPersentaseInputText.toDoubleOrNull() ?: 0.0
            }


            val diskon = hargaJerukInput * (diskonPersentaseInput / 100.0)


            val totalBayar = hargaJerukInput - diskon


            binding.tvDiskon.setText("Harga yang harus di bayar dengan diskon : " + totalBayar.toString())
        }


    }
}