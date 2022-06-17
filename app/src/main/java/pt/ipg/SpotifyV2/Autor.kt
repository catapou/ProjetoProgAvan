package pt.ipg.SpotifyV2

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Autor (


        var Autor_name: String,
        var Album: String,
        var id: Long = -1
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()


            valores.put(TabelaBDAutor.CAMPO_NOME, Autor_name)
            valores.put(TabelaBDAutor.CAMPO_ALBUM, Album)

            return valores
        }

        companion object {
            fun fromCursor(cursor: Cursor): Autor {
                val posId = cursor.getColumnIndex(BaseColumns._ID)
                val posNomeAutor = cursor.getColumnIndex(TabelaBDAutor.CAMPO_NOME)
                val posAlbum = cursor.getColumnIndex(TabelaBDAutor.CAMPO_ALBUM)

                val id = cursor.getLong(posId)
                val Autor_name = cursor.getString(posNomeAutor)
                val Album = cursor.getString(posAlbum)

                return Autor(Autor_name, Album, id)
            }
        }
    }
    
    
    
}