package br.edu.ifsp.dmo1.exercicio_avaliativo2.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database.DatabaseHelper
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database.UsuarioDao
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model.Usuario

class UsuarioRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)
    private val dao = UsuarioDao(dbHelper)

    fun getAll() = dao.getAll()

    fun getRuim() = dao.getRuim()

    fun getRegular() = dao.getRegular()

    fun getBom() = dao.getBom()

    fun getOtimo() = dao.getOtimo()

    fun exists(prontuario: String) = dao.exists(prontuario)

    fun insert(usuario: Usuario) = dao.insert(usuario)

}