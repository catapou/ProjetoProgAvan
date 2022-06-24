package pt.ipg.SpotifyV2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Playlists_Musicas (


        var Playlist_id: Long,
        var Musicas_id: Long,
        var id: Long = -1
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()


            valores.put(TabelaBDPlaylists_Musicas.ID_PLAYPLIST, Playlist_id)
            valores.put(TabelaBDPlaylists_Musicas.ID_MUSICAS, Musicas_id)

            return valores
        }

        companion object {
            fun fromCursor(cursor: Cursor): Playlists_Musicas {
                val posId = cursor.getColumnIndex(BaseColumns._ID)
                val posNomeAutor = cursor.getColumnIndex(TabelaBDPlaylists_Musicas.ID_PLAYPLIST)
                val posAlbum = cursor.getColumnIndex(TabelaBDPlaylists_Musicas.ID_MUSICAS)

                val id = cursor.getLong(posId)
                val ID_PLAYPLIST = cursor.getLong(posNomeAutor)
                val ID_MUSICAS = cursor.getLong(posAlbum)

                return Playlists_Musicas(ID_PLAYPLIST, ID_MUSICAS, id)
            }
        }
    }