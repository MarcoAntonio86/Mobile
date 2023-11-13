package devandroid.marcoantonio.jogoforca.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.jogoforca.Controller.JogoController;
import devandroid.marcoantonio.jogoforca.Model.Jogo;
import devandroid.marcoantonio.jogoforca.R;

public class MainActivity extends AppCompatActivity {

    JogoController controller;
    Jogo primeiro;

    EditText idinsira;
    EditText idtentativa;

    Button btnlimpar;
    Button btnsalvar;
    Button btnfinalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new JogoController(this);
        controller.toString();

        primeiro = new Jogo();

        controller.buscar(primeiro);

        idinsira = findViewById(R.id.idinsira);
        idtentativa = findViewById(R.id.idtentativa);

        idinsira.setText(primeiro.getInsiraPalvra());
        idtentativa.setText(primeiro.getTentativas());

        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinalizar = findViewById(R.id.btnfinalizar);

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            idinsira.setText("");
            idtentativa.setText("");

            controller.limpar();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            primeiro.setInsiraPalvra(idinsira.getText().toString());
            primeiro.setTentativas(idtentativa.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvos com sucesso" + primeiro.toString(),Toast.LENGTH_LONG).show();

            controller.salvar(primeiro);
            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Log.i("POOAndroid", primeiro.toString());

    }
}