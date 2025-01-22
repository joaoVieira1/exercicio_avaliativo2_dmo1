package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.checar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.exercicio_avaliativo2.databinding.ActivityChecarBinding
import br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.finalizar.FinalizarActivity

class ChecarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChecarBinding
    private lateinit var viewModel: ChecarViewModel
    private lateinit var prontuario: String
    private lateinit var nome: String
    private lateinit var voto: String
    private lateinit var codigo: String
    private var resultadoChecked: Boolean = false
    private var resultadoInsert: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChecarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ChecarViewModel::class.java)

        configurandoBundle()
        configInitUI()
        configListeners()
        configObservers()
    }

    private fun configObservers(){
        viewModel.checked.observe(this, Observer {
            resultadoChecked = it
        })

        viewModel.insert.observe(this, Observer {
            resultadoInsert = it
        })


    }

    private fun configListeners(){
        binding.buttonFinalizarPesquisa.setOnClickListener { finalizarPesquisa() }
    }

    private fun configurandoBundle(){
        val extras = intent.extras

        if(extras != null){
            prontuario = extras.getString("prontuario").toString()
            nome = extras.getString("nome").toString()
            voto = extras.getString("voto").toString()
            codigo = extras.getString("codigo").toString()
        }

    }

    private fun configInitUI(){
        binding.textVoto.text = "QUALIDADE DE ENSINO " + voto
    }

    private fun finalizarPesquisa(){
        val inputCodigo = binding.inputCodigo.text.toString()

        viewModel.checked(inputCodigo, codigo)

        if(resultadoChecked){
            registrarVoto()

            if(resultadoInsert){
                val mIntent = Intent(this, FinalizarActivity::class.java)
                startActivity(mIntent)
            }else{
                Toast.makeText(this, "Este prontuário já cadastrou seu voto", Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this, "Código inválido", Toast.LENGTH_LONG).show()
        }

    }

    private fun registrarVoto(){
        viewModel.insert(prontuario, nome, voto)
    }

}