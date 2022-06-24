package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAutor(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL," +
                "$CAMPO_ALBUM TEXT NOT NULL))")
    }

    companion object {
        const val NOME = "Autor"
        const val CAMPO_NOME = "Autor_name"
        const val CAMPO_ALBUM = "Album"
        const val CAMPO_ID = "$NOME.${BaseColumns._ID}"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, CAMPO_NOME, CAMPO_ALBUM)
    }
}