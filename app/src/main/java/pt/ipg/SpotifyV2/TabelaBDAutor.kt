package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAutor(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL," +
                "$CAMPO_ALBUM TEXT NOT NULL), $CAMPO_DATE_DE_ENTRADA INTERGER NOT NULL)")
    }

    companion object {
        const val NOME = "Autor"
        const val CAMPO_NOME = "Autro_name"
        const val CAMPO_ALBUM = "Album"
        const val CAMPO_DATE_DE_ENTRADA = "Data_de_entrada"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, CAMPO_NOME, CAMPO_ALBUM, CAMPO_DATE_DE_ENTRADA)
    }
}