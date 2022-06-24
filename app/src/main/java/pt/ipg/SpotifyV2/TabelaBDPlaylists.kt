package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDPlaylists(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL" +
                ", $DATA_DA_CRIACAO INTERGER NOT NULL, $DURACAO_DE_PLAYLIST REAL NOT NULL, $NUMERO_DE_MUSICAS INTERGER NOT NULL," +
                "$DESCRICAO TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "Playlist"
        const val CAMPO_NOME = "nome_da_playlist"
        const val DATA_DA_CRIACAO = "data_de_criação"
        const val DURACAO_DE_PLAYLIST = "duração_de_playlist"
        const val NUMERO_DE_MUSICAS = "numero_de_musicas"
        const val DESCRICAO = "descrição"
        const val CAMPO_ID = "$NOME.${BaseColumns._ID}"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, CAMPO_NOME, DATA_DA_CRIACAO, DURACAO_DE_PLAYLIST, NUMERO_DE_MUSICAS, DESCRICAO)
    }
}