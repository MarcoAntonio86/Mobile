package devandroid.marcoantonio.applistaalunos.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.applistaalunos.Model.Pessoa;
import devandroid.marcoantonio.applistaalunos.View.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor ListaAlunos;

    public static final String NOME_PREFERENCES = "pref_lista";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        ListaAlunos = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Inciada");
        return super.toString();

    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Dados Salvos" + toString());

        ListaAlunos.putString("PrimeiroNome", pessoa.getPrimeiroNome());
        ListaAlunos.putString("Sobrenome", pessoa.getSobreNome());
        ListaAlunos.putString("Matricula", pessoa.getMatricula());
        ListaAlunos.putString("CPF", pessoa.getCpf());
        ListaAlunos.apply();

    }

    public Pessoa buscar (Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("Sobrenome", "NA"));
        pessoa.setMatricula(preferences.getString("Matricula", "NA"));
        pessoa.setCpf(preferences.getString("CPF", "NA"));
        return pessoa;

    }

    public  void limpar () {
        ListaAlunos.clear();
        ListaAlunos.apply();

    }

}
