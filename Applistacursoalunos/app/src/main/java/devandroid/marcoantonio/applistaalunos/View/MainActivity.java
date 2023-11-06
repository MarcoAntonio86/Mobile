package devandroid.marcoantonio.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.applistaalunos.Controller.PessoaController;
import devandroid.marcoantonio.applistaalunos.Model.Pessoa;
import devandroid.marcoantonio.applistaalunos.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_lista";

    PessoaController controller;
    Pessoa pessoa;
    Pessoa OutraPessoa;

    EditText id_nome;
    EditText id_sobrenome;
    EditText id_matricula;
    EditText id_cpf;

    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor ListaAlunos = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("Sobrenome", "NA"));
        pessoa.setMatricula(preferences.getString("Matricula", "NA"));
        pessoa.setCpf(preferences.getString("CPF", "NA"));


        id_nome = findViewById(R.id.id_nome);
        id_sobrenome = findViewById(R.id.id_sobrenome);
        id_matricula = findViewById(R.id.id_matricula);
        id_cpf = findViewById(R.id.id_cpf);

        id_nome.setText(pessoa.getPrimeiroNome());
        id_sobrenome.setText(pessoa.getSobreNome());
        id_matricula.setText(pessoa.getMatricula());
        id_cpf.setText(pessoa.getCpf());

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);






        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_nome.setText("");
                id_sobrenome.setText("");
                id_matricula.setText("");
                id_cpf.setText("");

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
                OutraPessoa.setPrimeiroNome(id_nome.getText().toString());
                OutraPessoa.setSobreNome(id_sobrenome.getText().toString());
                OutraPessoa.setMatricula(id_matricula.getText().toString());
                OutraPessoa.setCpf(id_cpf.getText().toString());


                ListaAlunos.putString("PrimeiroNome", pessoa.getPrimeiroNome());
                ListaAlunos.putString("Sobrenome", pessoa.getSobreNome());
                ListaAlunos.putString("Matricula", pessoa.getMatricula());
                ListaAlunos.putString("CPF", pessoa.getCpf());
                ListaAlunos.apply();
                controller.salvar(pessoa);


            }
        });



        Log.i("POOAndroid", pessoa.toString());


    }
}