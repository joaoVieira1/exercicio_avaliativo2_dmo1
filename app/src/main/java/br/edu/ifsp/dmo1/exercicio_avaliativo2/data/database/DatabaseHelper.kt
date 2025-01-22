package br.edu.ifsp.dmo1.exercicio_avaliativo2.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_KEYS.DATABASE_NAME, null, DATABASE_KEYS.DATABASE_VERSION) {

    object DATABASE_KEYS{
        const val DATABASE_NAME = "exercicio_avaliativo"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Usuario"
        const val COLUMN_PRONTUARIO = "prontuario"
        const val COLUMN_NOME = "nome"
        const val COLUMN_VOTO = "voto"
    }

    private companion object{
        const val CREATE_TABLE = "CREATE TABLE ${DATABASE_KEYS.TABLE_NAME} ("+
                "${DATABASE_KEYS.COLUMN_PRONTUARIO} TEXT NOT NULL, " +
                "${DATABASE_KEYS.COLUMN_NOME} TEXT NOT NULL, " +
                "${DATABASE_KEYS.COLUMN_VOTO} TEXT NOT NULL, " +
                "UNIQUE (${DATABASE_KEYS.COLUMN_PRONTUARIO}) )"

        const val DROP_TABLE = "DROP TABLE IF EXISTS ${DATABASE_KEYS.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }


}