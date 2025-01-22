package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.finalizar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.exercicio_avaliativo2.databinding.ActivityFinalizarBinding

class FinalizarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalizarBinding
    private lateinit var viewModel: FinalizarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalizarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(FinalizarViewModel::class.java)

        updateUI()
    }


    private fun updateUI(){
        val todos = viewModel.getTodos()
        val otimo =viewModel.getOtimo()
        val bom = viewModel.getBom()
        val regular = viewModel.getRegular()
        val ruim = viewModel.getRuim()

        binding.votosTotais.text = "Foram contabilizados ${todos} votos!"
        binding.votosOtimos.text = "Ensino ótimo: ${otimo}"
        binding.votosBons.text = "Ensino bom: ${bom}"
        binding.votosRegulares.text = "Ensino regular: ${regular}"
        binding.votosRuins.text = "Ensino ruim: ${ruim}"
    }



}