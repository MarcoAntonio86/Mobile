package devandroid.marcoantonio.listacurso.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.marcoantonio.listacurso.Model.Cursando;
import devandroid.marcoantonio.listacurso.View.MainActivity;

public class CursoController {
    SharedPreferences preferences;

    SharedPreferences.Editor ListaCurso;

    public static final String NOME_PREFERENCE = "pref_list";

    public CursoController(MainActivity mainActivity){
        super(mainActivity);
         preferences = mainActivity.getSharedPreferences(NOME_PREFERENCE,0);
        ListaCurso = preferences.edit();
    }
        @NonNull
        @Override
        public String toString() {
            Log.d("MVC_Controller", "Controller");
            return super.toString();
        }

        public void salvar(Cursando cursando) {

        }

}
