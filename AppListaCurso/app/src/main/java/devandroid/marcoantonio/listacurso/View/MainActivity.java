package devandroid.marcoantonio.listacurso.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import devandroid.marcoantonio.listacurso.Controller.CursoController;
import devandroid.marcoantonio.listacurso.Model.Curso;
import devandroid.marcoantonio.listacurso.R;

public class MainActivity extends AppCompatActivity {

        CursoController controller;
        Curso curso;

        EditText id_curso;

        Button btn_salvar;
        Button btn_excluir;
        Button btn_limpar;
        Button btn_finalizar;

        Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new CursoController(this);
        controller.toString();

        curso = new  Curso();

        controller.buscar(curso);

        id_curso =findViewById(R.id.id_curso);

        spinner = findViewById(R.id.spinner);

        id_curso.setText(curso.getCurso());

        btn_salvar = findViewById(R.id.btn_salvar);
        btn_excluir = findViewById(R.id.id_excluir);
        btn_limpar = findViewById(R.id.id_limpar);
        btn_finalizar = findViewById(R.id.id_finalizar);

    }
}