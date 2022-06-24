package pt.ipg.SpotifyV2

import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BDSpotifyV2OpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereAutor(db: SQLiteDatabase, autor: Autor) {
        autor.id = TabelaBDAutor(db).insert(autor.toContentValues())

        assertNotEquals(-1, autor.id)
    }

    private fun insereMusicas(db: SQLiteDatabase, musicas: Musicas) {
        musicas.id = TabelaBDAutor(db).insert(musicas.toContentValues())

        assertNotEquals(-1, musicas.id)
    }

    private fun inserePlaylists(db: SQLiteDatabase, playlists: PlayLists) {
        playlists.id = TabelaBDAutor(db).insert(playlists.toContentValues())

        assertNotEquals(-1, playlists.id)
    }


    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDSpotifyV2OpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDSpotifyV2OpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirAutor() {
        val db = getWritableDatabase()

        val autor = Autor("Couves", "olá")
        insereAutor(db, autor)

        db.close()
    }

    @Test
    fun consegueInserirMusicas() {
        val db = getWritableDatabase()

        val musicas = Musicas("Couves", "olá", 3034, "couves", 20000404, 1)
        insereMusicas(db, musicas)

        db.close()
    }

    @Test
    fun consegueInserirPlaylists() {
        val db = getWritableDatabase()

        val playlists = PlayLists("Couves", 20001005, 30340, 100, "TOP 100 HITs", 1)
        inserePlaylists(db, playlists)

        db.close()
    }

    @Test
    fun consegueAlterarAutor() {
        val db = getWritableDatabase()

        val autor = Autor("TESTE", "adeus")
        insereAutor(db, autor)

        autor.Autor_name = "Ficção científica"
        val registosAlterados = TabelaBDAutor(db).update(
            autor.toContentValues(),
            "${TabelaBDAutor.CAMPO_ID}=?",
            arrayOf("${autor.id}")
        )

        assertEquals(1, registosAlterados)

        db.close()
    }


    @Test
    fun consegueAlterarMusicas() {
        val db = getWritableDatabase()

        val musicas = Musicas("TESTE", "adeus", 2030, "até amanhã", 20000505, 2)
        insereMusicas(db, musicas)

        musicas.nome_de_musica = "Ficção científica"
        val registosAlterados = TabelaBDMusicas(db).update(
            musicas.toContentValues(),
            "${TabelaBDMusicas.CAMPO_ID}=?",
            arrayOf("${musicas.id}")
        )

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarPlaylists() {
        val db = getWritableDatabase()

        val playlists = PlayLists("TESTE", 20010101, 200030, 1000, "TOP 1000 HITs", 2)
        inserePlaylists(db, playlists)

        playlists.nome_da_playlist = "Ficção científica"
        val registosAlterados = TabelaBDMusicas(db).update(
            playlists.toContentValues(),
            "${TabelaBDMusicas.CAMPO_ID}=?",
            arrayOf("${playlists.id}")
        )

        assertEquals(1, registosAlterados)

        db.close()
    }


    @Test
    fun consegueEliminarAutor() {
        val db = getWritableDatabase()

        val autor = Autor("TESTE", "adeus")
        insereAutor(db, autor)

        val registosEliminados = TabelaBDAutor(db).delete(
            "${TabelaBDAutor.CAMPO_ID}=?",
            arrayOf("${autor.id}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun consegueEliminarMusicas() {
        val db = getWritableDatabase()

        val musicas = Musicas("TESTE", "adeus", 2030, "até amanhã", 20000505, 2)
        insereMusicas(db, musicas)

        val registosEliminados = TabelaBDMusicas(db).delete(
            "${TabelaBDMusicas.CAMPO_ID}=?",
            arrayOf("${musicas.id}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }


    @Test
    fun consegueEliminarPlaylists() {
        val db = getWritableDatabase()

        val playlists = PlayLists("TESTE", 20010101, 200030, 1000, "TOP 1000 HITs", 2)
        inserePlaylists(db, playlists)

        val registosEliminados = TabelaBDPlaylists(db).delete(
            "${TabelaBDPlaylists.CAMPO_ID}=?",
            arrayOf("${playlists.id}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }

}