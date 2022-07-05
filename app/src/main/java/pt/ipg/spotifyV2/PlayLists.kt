package pt.ipg.SpotifyV2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class PlayLists (


        var nome_da_playlist: String,
        var data_de_criacao: Long,
        var duracao_de_playlist: Long,
        var numero_de_musicas: Long,
        var descricao: String,
        var id: Long = -1
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()


            valores.put(TabelaBDPlaylists.CAMPO_NOME, nome_da_playlist)
            valores.put(TabelaBDPlaylists.DATA_DA_CRIACAO, data_de_criacao)
            valores.put(TabelaBDPlaylists.DURACAO_DE_PLAYLIST, duracao_de_playlist)
            valores.put(TabelaBDPlaylists.NUMERO_DE_MUSICAS, numero_de_musicas)
            valores.put(TabelaBDPlaylists.DESCRICAO, descricao)

            return valores
        }

        companion object {
            fun fromCursor(cursor: Cursor): PlayLists {
                val posId = cursor.getColumnIndex(BaseColumns._ID)
                val posNomeAutor = cursor.getColumnIndex(TabelaBDPlaylists.CAMPO_NOME)
                val posAlbum = cursor.getColumnIndex(TabelaBDPlaylists.DATA_DA_CRIACAO)
                val posDuracao = cursor.getColumnIndex(TabelaBDPlaylists.DURACAO_DE_PLAYLIST)
                val posMusica = cursor.getColumnIndex(TabelaBDPlaylists.NUMERO_DE_MUSICAS)
                val posLancamento = cursor.getColumnIndex(TabelaBDPlaylists.DESCRICAO)

                val id = cursor.getLong(posId)
                val CAMPO_NOME = cursor.getString(posNomeAutor)
                val DATA_DA_CRIACAO = cursor.getLong(posAlbum)
                val DURACAO_DE_PLAYLIST = cursor.getLong(posDuracao)
                val NUMERO_DE_MUSICAS = cursor.getLong(posMusica)
                val DESCRICAO = cursor.getString(posLancamento)

                return PlayLists(CAMPO_NOME, DATA_DA_CRIACAO, DURACAO_DE_PLAYLIST, NUMERO_DE_MUSICAS, DESCRICAO, id)
            }
        }
    }