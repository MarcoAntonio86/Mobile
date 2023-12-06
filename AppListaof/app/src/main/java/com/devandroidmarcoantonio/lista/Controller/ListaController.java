package com.devandroidmarcoantonio.lista.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.devandroidmarcoantonio.lista.DataBase.DBHelper;
import com.devandroidmarcoantonio.lista.Model.Lista;
import com.devandroidmarcoantonio.lista.View.MainActivity;

public class ListaController {
    private DBHelper dbHelper;
    private Context context;

    private SharedPreferences preferences;
    private SharedPreferences.Editor listaItem;

    public static final String NOME_PREFERENCES = "pref_lista";

    public ListaController(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);


        preferences = context.getSharedPreferences(NOME_PREFERENCES, 0);
        listaItem = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada");
        return super.toString();
    }

    public void salvar(Lista lista) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NOME_ITEM, lista.getNomeItem());

        try {
            db.insertOrThrow(DBHelper.TABLE_NAME, null, values);
        } catch (SQLException e) {

        } finally {
            db.close();
        }


        listaItem.putString("NomeItem", lista.getNomeItem());
        listaItem.apply();

        Log.d("MVC_Controller", "Dados Salvos com Sucesso!!!" + toString());
    }

    public Lista buscar(Lista lista) {

        lista.setNomeItem(preferences.getString("NomeItem", "NA"));


        SQLiteDatabase db = dbHelper.getReadableDatabase();

        db.close();

        return lista;
    }

    public void limpar() {

        listaItem.clear();
        listaItem.apply();


        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.close();
    }

    public void excluirItemDoBanco(String item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = DBHelper.COLUMN_NOME_ITEM + " = ?";
        String[] selectionArgs = {item};

        try {
            db.delete(DBHelper.TABLE_NAME, selection, selectionArgs);
        } catch (SQLException e) {

            Log.e("MVC_Controller", "Erro ao excluir item do banco de dados: " + e.getMessage());
        } finally {
            db.close();
        }
    }
}
