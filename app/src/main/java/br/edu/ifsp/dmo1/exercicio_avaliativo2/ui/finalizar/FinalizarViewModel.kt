package br.edu.ifsp.dmo1.exercicio_avaliativo2.ui.finalizar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.repository.UsuarioRepository

class FinalizarViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var repository: UsuarioRepository

    init{
        repository = UsuarioRepository(application)
    }

    fun getTodos(): Int{
        return repository.getAll().size
    }

    fun getOtimo(): Int{
        return repository.getOtimo().size
    }

    fun getBom(): Int{
        return repository.getBom().size
    }

    fun getRegular(): Int{
        return repository.getRegular().size
    }

    fun getRuim(): Int{
        return repository.getRuim().size
    }

}