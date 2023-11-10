package devandroid.marcoantonio.calculadorasimples.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.calculadorasimples.Model.Calculo;
import devandroid.marcoantonio.calculadorasimples.View.MainActivity;

public class CalculadoraController {

    SharedPreferences preferences;
    SharedPreferences.Editor Calculo;

    public static final String NOME_PREFERENCES = "pref_calculo";

    public CalculadoraController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        Calculo = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Inciada");

        return super.toString();
    }

     public Calculo buscar (Calculo calculo) {
        calculo.setPrimeiroNumero(preferences.getString("PrimeiroNumero", "NA"));
        calculo.setSegundoNumero(preferences.getString("SegundoNumero", "NA"));
        calculo.setSimboloEscolhido(preferences.getString("SimboloEscolhido", "NA"));
        return calculo;

     }

     public void limpar () {
         Calculo.clear();
         Calculo.apply();
     }
}
