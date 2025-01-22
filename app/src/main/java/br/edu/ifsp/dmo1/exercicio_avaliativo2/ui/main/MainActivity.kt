package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.exercicio_avaliativo2.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.participar.ParticiparActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configListener()
    }

    private fun configListener(){
        binding.participarButton.setOnClickListener { getActivityParticipar() }
    }

    private fun getActivityParticipar(){
        val mIntent = Intent(this, ParticiparActivity::class.java)
        startActivity(mIntent)
    }

}