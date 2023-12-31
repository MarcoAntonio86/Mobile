package devandroid.marcoantonio.listacurso.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import devandroid.marcoantonio.listacurso.Model.Cursando;
import devandroid.marcoantonio.listacurso.Model.Curso;
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

            ContentValues dados = new ContentValues();

            ListaCurso.putString("nomeCurso", cursando.getNomeCurso());
            ListaCurso.apply();

            dados.put("nomeCurso", cursando.getNomeCurso());
            // dados.put("recomendacao", combustivel.getRecomendacao()); você tem de descobrir o equivalente a isso p/ o codigo

            salvarObjeto("curso", dados);
        }

        public Curso buscar (Curso curso){
            curso.setCurso(preferences.getString("Curso", "NA"));
            return curso;
        }

        public static List<Cursando> getListaDados() {
            return ListaDados();
        }

        public void alterar (Curso curso) {
            ContentValues dados = new ContentValues();

            dados.put("id", curso.getID());
            //  dados.put("recomendacao", combustivel.getRecomendacao()); ver o equivalente
            alterarObjeto("Curso", dados);
        }

        public void deletar(int id) {deletarObjeto("curso", id);}

        public void limpar() {
            ListaCurso.clear();
            ListaCurso.apply();
        }

}
