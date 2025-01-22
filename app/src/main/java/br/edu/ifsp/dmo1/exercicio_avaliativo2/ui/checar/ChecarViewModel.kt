package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.checar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model.Usuario
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.repository.UsuarioRepository

class ChecarViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var repository: UsuarioRepository

    private val _checked = MutableLiveData<Boolean>()
    val checked: LiveData<Boolean> = _checked

    private val _insert = MutableLiveData<Boolean>()
    val insert: LiveData<Boolean> = _insert

    init{
        repository = UsuarioRepository(application)
    }

    fun checked(codigoInput: String, codigo: String){
        if(codigoInput.equals(codigo)){
            _checked.value = true
        }else{
            _checked.value = false
        }
    }

    fun insert(prontuario: String, nome: String, voto: String){
        val result = repository.insert(Usuario(prontuario, nome, voto))

        if(result > -1L){
            _insert.value = true
        }else{
            _insert.value = false
        }
    }

}