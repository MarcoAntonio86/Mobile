package devandroid.marcoantonio.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.applistaalunos.Model.Pessoa;
import devandroid.marcoantonio.applistaalunos.R;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Pessoa OutraPessoa;

    String DadosPessoas;
    String DadosOutraPessoa;

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

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Batman");
        pessoa.setSobreNome("Heroi");
        pessoa.setMatricula("10101010");
        pessoa.setCpf("99999999999");

        OutraPessoa = new Pessoa();
        /*OutraPessoa.setPrimeiroNome("Coringa");
        OutraPessoa.setSobreNome("Vilão");
        OutraPessoa.setMatricula("11111111");
        OutraPessoa.setCpf("11111111111");*/

        id_nome = findViewById(R.id.id_nome);
        id_sobrenome = findViewById(R.id.id_sobrenome);
        id_matricula = findViewById(R.id.id_matricula);
        id_cpf = findViewById(R.id.id_cpf);

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        id_nome.setText(pessoa.getPrimeiroNome());
        id_sobrenome.setText(pessoa.getSobreNome());
        id_matricula.setText(pessoa.getMatricula());
        id_cpf.setText(pessoa.getCpf());

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
                Toast.makeText( MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
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

                Toast.makeText(MainActivity.this, "Dados Salvos" + OutraPessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });




       /* DadosPessoas = "Primeiro nome: ";
        DadosPessoas += pessoa.getPrimeiroNome();
        DadosPessoas += "Sobrenome: ";
        DadosPessoas += pessoa.getSobreNome();
        DadosPessoas += "Matrícula: ";
        DadosPessoas += pessoa.getMatricula();
        DadosPessoas += "CPF: ";
        DadosPessoas += pessoa.getCpf();

        DadosOutraPessoa = "Primeiro nome: ";
        DadosOutraPessoa += pessoa.getPrimeiroNome();
        DadosOutraPessoa += "Sobrenome: ";
        DadosOutraPessoa += pessoa.getSobreNome();
        DadosOutraPessoa += "Matrícula: ";
        DadosOutraPessoa += pessoa.getMatricula();
        DadosOutraPessoa += "CPF: ";
        DadosOutraPessoa += pessoa.getCpf();*/

        Log.i("POOAndroid",pessoa.toString());
        Log.i("POOAndroid",OutraPessoa.toString());



    }
}