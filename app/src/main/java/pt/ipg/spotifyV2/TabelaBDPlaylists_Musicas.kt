package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDPlaylists_Musicas(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $ID_PLAYPLIST INTEGER NOT NULL, $ID_MUSICAS INTEGER NOT NULL," +
                " FOREIGN KEY I$ID_PLAYPLIST) REFERENCES ${TabelaBDPlaylists.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT, FOREIGN KEY I$ID_MUSICAS) REFERENCES ${TabelaBDMusicas.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT) ")
    }

    companion object {
        const val NOME = "PlayLists_Musicas"
        const val ID_PLAYPLIST = "Playlist_id"
        const val ID_MUSICAS = "Musicas_id"
        const val CAMPO_ID = "${TabelaBDAutor.NOME}.${BaseColumns._ID}"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, ID_PLAYPLIST)
    }
}