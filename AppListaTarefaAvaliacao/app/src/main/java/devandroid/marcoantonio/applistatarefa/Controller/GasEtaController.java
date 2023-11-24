package devandroid.marcoantonio.applistatarefa.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.applistatarefa.DataBase.GasEtaDB;
import devandroid.marcoantonio.applistatarefa.Model.Combustivel;
import devandroid.marcoantonio.applistatarefa.Model.Gaseta;
import devandroid.marcoantonio.applistatarefa.View.GasEtaAcivity;

public class GasEtaController extends GasEtaDB {
    SharedPreferences preferences;

    SharedPreferences.Editor ListaCombustivel;

    public static final String NOME_PREFERENCES = "pref_lista";


    public GasEtaController(GasEtaAcivity gasEtaAcivity) {
        super(gasEtaAcivity);

        preferences = gasEtaAcivity.getSharedPreferences(NOME_PREFERENCES, 0);
        ListaCombustivel = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada");
        return super.toString();
    }

    public void salvar (Combustivel combustivel){
        //Log.d("MVC_Controller", "Dados Salvos com sucesso" + toString());

        ContentValues dados = new ContentValues();

        ListaCombustivel.putString("combustivel", combustivel.getNomeCombustivel());
        ListaCombustivel.putFloat("precoCombustivel",(float) combustivel.getPrecoCombustivel());
        ListaCombustivel.putString("recomendacao", combustivel.getRecomendacao());
        ListaCombustivel.apply();

        dados.put("nomeCombustivel", combustivel.getNomeCombustivel() );
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("combustivel", dados);
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
