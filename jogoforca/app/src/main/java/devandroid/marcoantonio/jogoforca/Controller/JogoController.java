package devandroid.marcoantonio.jogoforca.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.jogoforca.Model.Jogo;
import devandroid.marcoantonio.jogoforca.View.MainActivity;

public class JogoController {

        SharedPreferences preferences;
        SharedPreferences.Editor ListaJogo;
        public static final String NOME_PREFERENCES = "pref_listajogo";

    public JogoController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        ListaJogo = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Inciada");
        return super.toString();
    }

    public void salvar(Jogo primeiro){
        Log.d("MVC_Controller", "Dados Salvos" + toString());
        ListaJogo.putString("InsiraPalavra", primeiro.getInsiraPalvra());
        ListaJogo.putString("Tentativas", primeiro.getTentativas());
        ListaJogo.apply();
    }

    public Jogo buscar(Jogo primeiro){
        primeiro.setInsiraPalvra(preferences.getString("InsiraPalvara", "NA"));
        primeiro.setTentativas(preferences.getString("Tentativa", "NA"));
        return primeiro;

    }

    public void limpar(){
     ListaJogo.clear();
     ListaJogo.apply();
    }
}
