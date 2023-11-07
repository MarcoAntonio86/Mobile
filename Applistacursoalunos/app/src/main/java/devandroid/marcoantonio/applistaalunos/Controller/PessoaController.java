package devandroid.marcoantonio.applistaalunos.Controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.applistaalunos.Model.Pessoa;

public class PessoaController {
    @NonNull
    @Override
    public String toString() {
        Log.d( "MVC_Controller", "Controller Inciada");
        return super.toString();

    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Dados Salvos" + toString());
    }


}
