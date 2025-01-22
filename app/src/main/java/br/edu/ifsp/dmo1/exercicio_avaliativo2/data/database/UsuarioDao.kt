package br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database

import android.content.ContentValues
import br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model.Usuario

class UsuarioDao(private val dbHelper: DatabaseHelper) {

    fun insert(usuario: Usuario): Long{

        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO, usuario.prontuario)
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_NOME, usuario.nome)
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO, usuario.voto)
        }

        return db.insert(DatabaseHelper.DATABASE_KEYS.TABLE_NAME, null, values)

    }

    fun getAll(): List<Usuario>{

        val usuarios = mutableListOf<Usuario>()
        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val cursor = db.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null,
            )

        cursor.use {
            while(cursor.moveToNext()){
                usuarios.add(
                    Usuario(prontuario = it.getString(0), nome = it.getString(1), voto = it.getString(2))
                )
            }
        }

        return usuarios

    }

    fun getRuim(): List<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val voto = Usuario.VOTOS.RUIM
        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO} = ?"
        val whereArgs = arrayOf(voto)

        val cursor = db.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            where,
            whereArgs,
            null,
            null,
            null,
        )

        cursor.use {
            while(cursor.moveToNext()){
                usuarios.add(
                    Usuario(prontuario = it.getString(0), nome = it.getString(1), voto = it.getString(2))
                )
            }
        }

        return usuarios
    }

    fun getRegular(): List<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val voto = Usuario.VOTOS.REGULAR
        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO} = ?"
        val whereArgs = arrayOf(voto)

        val cursor = db.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            where,
            whereArgs,
            null,
            null,
            null,
        )

        cursor.use {
            while(cursor.moveToNext()){
                usuarios.add(
                    Usuario(prontuario = it.getString(0), nome = it.getString(1), voto = it.getString(2))
                )
            }
        }

        return usuarios
    }

    fun getBom(): List<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val voto = Usuario.VOTOS.BOM
        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO} = ?"
        val whereArgs = arrayOf(voto)

        val cursor = db.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            where,
            whereArgs,
            null,
            null,
            null,
        )

        cursor.use {
            while(cursor.moveToNext()){
                usuarios.add(
                    Usuario(prontuario = it.getString(0), nome = it.getString(1), voto = it.getString(2))
                )
            }
        }

        return usuarios
    }

    fun getOtimo(): List<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val voto = Usuario.VOTOS.OTIMO
        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO} = ?"
        val whereArgs = arrayOf(voto)

        val cursor = db.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            where,
            whereArgs,
            null,
            null,
            null,
        )

        cursor.use {
            while(cursor.moveToNext()){
                usuarios.add(
                    Usuario(prontuario = it.getString(0), nome = it.getString(1), voto = it.getString(2))
                )
            }
        }

        return usuarios
    }

    fun exists(prontuario: String): Boolean{

        val db = dbHelper.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO,
            DatabaseHelper.DATABASE_KEYS.COLUMN_NOME,
            DatabaseHelper.DATABASE_KEYS.COLUMN_VOTO)

        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_PRONTUARIO} = ?"
        val whereArgs = arrayOf(prontuario)

        val cursor = db.query(
            DatabaseHelper.DATABASE_KEYS.TABLE_NAME,
            columns,
            where,
            whereArgs,
            null,
            null,
            null
        )

        cursor.use {
            if(cursor.moveToNext()){
                return true
            }
        }

        return false
    }

}