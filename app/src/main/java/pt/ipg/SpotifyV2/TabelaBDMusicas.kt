package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMusicas(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL" +
                ", $NOME_ALBUM TEXT NOT NULL, $DURACAO REAL NOT NULL, $NOME_DE_MUSICA TEXT NOT NULL, $DATA_DE_LANCAMENTO INTERGER NOT NULL)")
    }

    companion object {
        const val NOME = "Musicas"
        const val CAMPO_NOME = "Nome_autor"
        const val NOME_ALBUM = "nome_album"
        const val DURACAO = "duração"
        const val NOME_DE_MUSICA = "nome_de_musica"
        const val DATA_DE_LANCAMENTO = "data_de_lançamento"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, CAMPO_NOME, NOME_ALBUM, DURACAO, NOME_DE_MUSICA, DATA_DE_LANCAMENTO)
    }
}