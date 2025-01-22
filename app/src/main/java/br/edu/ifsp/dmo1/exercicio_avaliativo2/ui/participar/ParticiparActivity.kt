package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.participar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.exercicio_avaliativo2.R
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model.Usuario
import br.edu.ifsp.dmo1.exercicio_avaliativo2.databinding.ActivityParticiparBinding
import br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.checar.ChecarActivity


class ParticiparActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticiparBinding
    private lateinit var prontuario: String
    private lateinit var nome: String
    private lateinit var voto: String
    private lateinit var codigo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParticiparBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configInitUI()
        configListeners()

    }

    private fun configInitUI(){
        binding.buttonChecarVoto.visibility = View.GONE
    }

    private fun configListeners(){
        binding.buttonRegistrarVoto.setOnClickListener { registraVoto()  }
        binding.buttonChecarVoto.setOnClickListener { getChecarActitivy() }

        binding.radiogroupVotos.setOnCheckedChangeListener { _, checkedId ->
            if(checkedId == R.id.radio_ruim){
                voto = Usuario.VOTOS.RUIM
            }

            if(checkedId == R.id.radio_regular){
                voto = Usuario.VOTOS.REGULAR
            }

            if(checkedId == R.id.radio_bom){
                voto = Usuario.VOTOS.BOM
            }

            if(checkedId == R.id.radio_otimo){
                voto = Usuario.VOTOS.OTIMO
            }
        }

    }

    private fun pegarDados(){
        prontuario = binding.inputProntuario.text.toString()
        nome = binding.inputNome.text.toString()
    }

    private fun registraVoto(){
        pegarDados()

        codigo = prontuario + "XYZ"

        binding.descricaoCodigoVerificacao.text = "Código de verificação do voto:"
        binding.codigoVerificacao.text = codigo
        binding.buttonChecarVoto.visibility = View.VISIBLE

    }

    private fun getChecarActitivy(){

        val extras = Bundle()

        extras.putString("prontuario", prontuario)
        extras.putString("nome", nome)
        extras.putString("voto", voto)
        extras.putString("codigo", codigo)

        val mIntent = Intent(this, ChecarActivity::class.java)
        mIntent.putExtras(extras)
        startActivity(mIntent)

    }

}
