package com.devandroidmarcoantonio.lista.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.devandroidmarcoantonio.lista.Model.Lista;
import com.devandroidmarcoantonio.lista.View.MainActivity;

public class ListaController {
    SharedPreferences perferences;
    SharedPreferences.Editor ListaItem;

    public static final String NOME_PREFERENCES = "pref_lista";

    public ListaController(MainActivity mainActivity) {
        perferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        ListaItem = perferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Iniciada");
        return super.toString();

}

public void salvar(Lista lista){
    Log.d("MVC_Controller", "Dados Salvos com Sucesso!!!" + toString());

    ListaItem.putString("NomeItem",lista.getNomeItem());
    ListaItem.apply();
}

public Lista buscar(Lista lista) {
    lista.setNomeItem(perferences.getString("NomeItem","NA"));
    return lista;
    }

    public void limpar(){
        ListaItem.clear();
        ListaItem.apply();
    }
}
