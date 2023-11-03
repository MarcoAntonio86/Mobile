package com.marcoantonio.jogodaforca.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marcoantonio.jogodaforca.Model.Jogar;
import com.marcoantonio.jogodaforca.R;

public class MainActivity extends AppCompatActivity {
        Jogar jogo;
        Jogar outrojogo;

        EditText idlista;
        EditText idtentativa;

        Button btnconfirmar;
        Button btnlimpar;
        Button btnsalvar;
        Button btnfinalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogo = new Jogar();
        jogo.setInsirapalavras("Bolacha");
        jogo.setTentativa("C");

        outrojogo = new Jogar();

        idlista = findViewById(R.id.idlista);
        idtentativa = findViewById(R.id.idtentativa);

        btnconfirmar = findViewById(R.id.btnconfirmar);
        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinalizar = findViewById(R.id.btnfinalizar);

        idlista.setText(jogo.getInsirapalavras());
        idtentativa.setText(jogo.getTentativa());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idlista.setText("");
                idtentativa.setText("");
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
                outrojogo.setInsirapalavras(idlista.getText().toString());
                outrojogo.setTentativa(idtentativa.getText().toString());
                Toast.makeText(MainActivity.this, "Dados Salvos" + outrojogo.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Log.i("POOAndroid", jogo.toString());


    }
}