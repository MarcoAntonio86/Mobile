package com.marcoantonio.gerenciadordesenhas.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marcoantonio.gerenciadordesenhas.Model.Senhas;
import com.marcoantonio.gerenciadordesenhas.R;

public class MainActivity extends AppCompatActivity {

    Senhas digito;
    Senhas outrodigito;

    EditText idsenhamaster;
    EditText idsenhasalva;

    Button btnmostrarlista;
    Button idlistasdesenhas;
    Button btnlimpar;
    Button btnsalvar;
    Button btnfinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            digito = new Senhas();
            digito.setSenhamaster("123");
            digito.setSenhassalvas("456");

            outrodigito = new Senhas();

            idsenhamaster = findViewById(R.id.idsenhamaster);
            idsenhasalva = findViewById(R.id.idsenhasalva);

            btnmostrarlista = findViewById(R.id.btnmostrarlista);
            btnlimpar = findViewById(R.id.btnlimpar);
            btnsalvar = findViewById(R.id.btnsalvar);
            btnfinalizar = findViewById(R.id.btnfinalizar);

            idsenhamaster.setText(digito.getSenhamaster());
            idsenhasalva.setText(digito.getSenhassalvas());

            btnlimpar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idsenhamaster.setText("");
                    idsenhasalva.setText("");

                }
            });

            btnfinalizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText( MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                    finish();
                }
            });

            btnsalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    outrodigito.setSenhamaster(idsenhamaster.getText().toString());
                    outrodigito.setSenhassalvas(idsenhasalva.getText().toString());
                    Toast.makeText(MainActivity.this, "Dados Salvos" + outrodigito.toString(), Toast.LENGTH_LONG).show();
                }
            });
    }
}