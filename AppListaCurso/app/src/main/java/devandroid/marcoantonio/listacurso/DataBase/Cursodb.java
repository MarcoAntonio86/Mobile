package devandroid.marcoantonio.listacurso.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.marcoantonio.listacurso.Model.Cursando;
import devandroid.marcoantonio.listacurso.Model.Curso;

public class Cursodb extends SQLiteOpenHelper {

    private static final String DB_NAME = "curso_db";

    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public cursoDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override // sqLiteDatabase de não der certo db usa o sql...
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela =
                "CREATE TABLE curso (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nomeCurso TEXT)";
        db.execSQL(sqlTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }

    public List<Cursando> listaDados() {

        List<Cursando> lista = new ArrayList<>();

        Cursando registro;

        String querySql = "SELECT * FROM Cursando";

        cursor = db.rawQuery(querySql, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Cursando();

                registro.setId(cursor.getInt(0));
                registro.setNomeCurso(cursor.getString(1));
                lista.add(registro);
            } while (cursor.moveToNext());
        } else {
        }
        return lista;
    }
}

public void alterarObjeto(String tabela, ContentValues dados) {

 int id = dados.getAsInteger("id");

 db.update(tabela,dados,"id=?", new String[]{Integer.toString(id)});

}

public void deletarObjeto(String tabela, int id){
    db.delete(tabela,"id=?", new String[]{Integer.toString(id)});
}
}