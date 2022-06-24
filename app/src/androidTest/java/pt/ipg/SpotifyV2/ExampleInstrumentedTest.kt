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
    fun consegueEliminarAutor() {
        val db = getWritableDatabase()

        val Autor = Autor("TESTE", "adeus")
        insereAutor(db, Autor)

        val registosEliminados = TabelaBDAutor(db).delete(
            "${TabelaBDAutor.CAMPO_ID}=?",
            arrayOf("${Autor.id}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }

}