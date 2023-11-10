package devandroid.marcoantonio.cambio.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.cambio.Model.Cambial;
import devandroid.marcoantonio.cambio.View.MainActivity;

public class CambioController {

        SharedPreferences preferences;
        SharedPreferences.Editor CambioAtual;

        public static final String NOME_PREFERENCES = "pref_Cambio";

    public CambioController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        CambioAtual = preferences.edit();
    }
    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Iniciada");
        return super.toString();

    }

    public Cambial buscar (Cambial vlrcambio) {
         vlrcambio.setMoeda1(preferences.getString("Moeda1", "NA"));
         vlrcambio.setMoeda2(preferences.getString("Moeda2", "NA"));
         vlrcambio.setValor(preferences.getString("Valor", "NA"));
         vlrcambio.setDiferencaCambial(preferences.getString("DiferençaCambial", "NA"));
        return vlrcambio;
}

    public void limpar () {
            CambioAtual.clear();
            CambioAtual.apply();
    }





}
