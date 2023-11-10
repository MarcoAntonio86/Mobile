package devandroid.marcoantonio.listatarefa.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.listatarefa.Model.Listada;

public class ListaController {
    SharedPreferences preferences;
    SharedPreferences.Editor ListaTarefas;

    public static final String NOME_PREFERENCES = "pref_listaTarefa";



    public ListaController(devandroid.marcoantonio.listatarefa.View.MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        ListaTarefas = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Inciada");
        return super.toString();

    }

   public void salvar (Listada vlrinserido){
       Log.d("MVC_Controller", "Dados Salvos" + toString());

        ListaTarefas.putString("InsiraTarefa", vlrinserido.getInsiratarefa());
        ListaTarefas.apply();
}

    public Listada buscar (Listada vlrinserido){
        vlrinserido.setInsiratarefa(preferences.getString("InsiraTarefa", "NA"));
        return vlrinserido;
    }
    public void limpar () {
        ListaTarefas.clear();
        ListaTarefas.apply();
    }
}
