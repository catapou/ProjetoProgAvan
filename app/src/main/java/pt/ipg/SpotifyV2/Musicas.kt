package pt.ipg.SpotifyV2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Musicas (


        var Nome_autor: String,
        var nome_album: String,
        var duracao: Long,
        var nome_de_musica: String,
        var data_de_lancamento: Long,
        var id: Long = -1
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()


            valores.put(TabelaBDMusicas.CAMPO_NOME, Nome_autor)
            valores.put(TabelaBDMusicas.NOME_ALBUM, nome_album)
            valores.put(TabelaBDMusicas.DURACAO, duracao)
            valores.put(TabelaBDMusicas.NOME_DE_MUSICA, nome_de_musica)
            valores.put(TabelaBDMusicas.DATA_DE_LANCAMENTO, data_de_lancamento)

            return valores
        }

        companion object {
            fun fromCursor(cursor: Cursor): Musicas {
                val posId = cursor.getColumnIndex(BaseColumns._ID)
                val posNomeAutor = cursor.getColumnIndex(TabelaBDMusicas.CAMPO_NOME)
                val posAlbum = cursor.getColumnIndex(TabelaBDMusicas.NOME_ALBUM)
                val posDuracao = cursor.getColumnIndex(TabelaBDMusicas.DURACAO)
                val posMusica = cursor.getColumnIndex(TabelaBDMusicas.NOME_DE_MUSICA)
                val posLancamento = cursor.getColumnIndex(TabelaBDMusicas.DATA_DE_LANCAMENTO)

                val id = cursor.getLong(posId)
                val Autor_name = cursor.getString(posNomeAutor)
                val Album = cursor.getString(posAlbum)
                val Duracao = cursor.getLong(posDuracao)
                val Musica = cursor.getString(posMusica)
                val Lancamento = cursor.getLong(posLancamento)

                return Musicas(Autor_name, Album, Duracao, Musica, Lancamento, id)
            }
        }
    }