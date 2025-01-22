package br.edu.ifsp.dmo1.exercicio_avaliativo2.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database.DatabaseHelper
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database.UsuarioDao
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model.Usuario

class UsuarioRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)
    private val dao = UsuarioDao(dbHelper)

    fun getAll(): List<Usuario> = dao.getAll()

    fun getRuim(): List<Usuario> = dao.getRuim()

    fun getRegular(): List<Usuario> = dao.getRegular()

    fun getBom(): List<Usuario> = dao.getBom()

    fun getOtimo(): List<Usuario> = dao.getOtimo()

    fun exists(prontuario: String): Boolean = dao.exists(prontuario)

    fun insert(usuario: Usuario): Long = dao.insert(usuario)

}