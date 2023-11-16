package devandroid.marcoantonio.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.marcoantonio.applistaalunos.Controller.CursoController;
import devandroid.marcoantonio.applistaalunos.Controller.PessoaController;
import devandroid.marcoantonio.applistaalunos.Model.Pessoa;
import devandroid.marcoantonio.applistaalunos.R;

public class MainActivity extends AppCompatActivity {

    CursoController cursoController;
    PessoaController controller;
    Pessoa pessoa;

    List<String> nomesCursos;

    EditText id_nome;
    EditText id_sobrenome;
    EditText id_matricula;
    EditText id_cpf;

    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(this);
        controller.toString();

        cursoController = new CursoController();
        nomesCursos = cursoController.getListacursos();
        cursoController.getListacursos();

        pessoa = new Pessoa();

        controller.buscar(pessoa);

        id_nome = findViewById(R.id.id_nome);
        id_sobrenome = findViewById(R.id.id_sobrenome);
        id_matricula = findViewById(R.id.id_matricula);
        id_cpf = findViewById(R.id.id_cpf);

        spinner = findViewById(R.id.spinner);

        id_nome.setText(pessoa.getPrimeiroNome());
        id_sobrenome.setText(pessoa.getSobreNome());
        id_matricula.setText(pessoa.getMatricula());
        id_cpf.setText(pessoa.getCpf());

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        ArrayAdapter<String > adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_nome.setText("");
                id_sobrenome.setText("");
                id_matricula.setText("");
                id_cpf.setText("");

                controller.limpar();

            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(id_nome.getText().toString());
                pessoa.setSobreNome(id_sobrenome.getText().toString());
                pessoa.setMatricula(id_matricula.getText().toString());
                pessoa.setCpf(id_cpf.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvos com sucesso" + pessoa.toString(),Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);

            }
        });

        Log.i("POOAndroid", pessoa.toString());


    }
}