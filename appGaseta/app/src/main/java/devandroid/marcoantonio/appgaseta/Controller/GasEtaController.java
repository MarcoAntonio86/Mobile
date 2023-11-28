package devandroid.marcoantonio.appgaseta.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import devandroid.marcoantonio.appgaseta.DataBase.GasEtaDB;
import devandroid.marcoantonio.appgaseta.Model.Combustivel;
import devandroid.marcoantonio.appgaseta.Model.Gaseta;
import devandroid.marcoantonio.appgaseta.View.GasEtaAcivity;

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


    public List<Combustivel> getlistDados() {
        return listDados();
    }

    public void  alterar(Combustivel combustivel){
        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel", dados);
    }

    public void deletar(int id){
        deletarObjeto("Combustivel", id);
    }

    public void limpar () {
        ListaCombustivel.clear();
        ListaCombustivel.apply();
    }
}
