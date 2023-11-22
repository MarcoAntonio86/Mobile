package devandroid.marcoantonio.appgaseta.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.appgaseta.Model.Gaseta;
import devandroid.marcoantonio.appgaseta.View.GasEtaAcivity;

public class GasEtaController {
    SharedPreferences preferences;

    SharedPreferences.Editor ListaCombustivel;

    public static final String NOME_PREFERENCES = "pref_lista";


    public GasEtaController(GasEtaAcivity gasEtaAcivity) {
        preferences = gasEtaAcivity.getSharedPreferences(NOME_PREFERENCES, 0);
        ListaCombustivel = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada");
        return super.toString();
    }

    public void salvar (Gaseta gaseta){
        Log.d("MVC_Controller", "Dados Salvos com sucesso" + toString());

        ListaCombustivel.putString("Posto", gaseta.getPosto());
        ListaCombustivel.putString("Gasolina", gaseta.getGasolina());
        ListaCombustivel.putString("Etanol", gaseta.getEtanol());
        ListaCombustivel.apply();
    }

    public Gaseta buscar (Gaseta gaseta){
        gaseta.setPosto(preferences.getString("Posto", "NA"));
        gaseta.setGasolina(preferences.getString("Gasolina", "NA"));
        gaseta.setEtanol(preferences.getString("Etanol", "NA"));
        return gaseta;
    }

    public void limpar () {
        ListaCombustivel.clear();
        ListaCombustivel.apply();
    }
}
