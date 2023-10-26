package devandroid.marcoantonio.applistaalunos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.marcoantonio.applistaalunos.Model.Pessoa;
import devandroid.marcoantonio.applistaalunos.R;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Pessoa OutraPessoa;

    String DadosPessoas;
    String DadosOutraPessoa;

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
        OutraPessoa.setPrimeiroNome("Coringa");
        OutraPessoa.setSobreNome("Vilão");
        OutraPessoa.setMatricula("11111111");
        OutraPessoa.setCpf("11111111111");

        DadosPessoas = "Primeiro nome: ";
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
        DadosOutraPessoa += pessoa.getCpf();

        int parada = 0;






    }
}