package devandroid.marcoantonio.calculadorasimples.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.calculadorasimples.Model.Calculo;
import devandroid.marcoantonio.calculadorasimples.R;

public class MainActivity extends AppCompatActivity {
    Calculo calculo;
    Calculo outrocalculo;

    EditText  idnumero1;
    EditText  idnumero2;
    EditText  idsimbolo;

    Button btnlimpar;
    Button btncalculo;
    Button btnsalvar;
    Button btnfinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculo = new Calculo();
        calculo.setPrimeiroNumero("2");
        calculo.setSegundoNumero("2");
        calculo.setSimboloEscolhido("+");

        outrocalculo = new Calculo();

        idnumero1 = findViewById(R.id.idnumero1);
        idnumero2 = findViewById(R.id.idnumero2);
        idsimbolo = findViewById(R.id.idsimbolo);

        btnlimpar = findViewById(R.id.btnlimapr);
        btncalculo = findViewById(R.id.btncalculo);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinalizar = findViewById(R.id.btnfinalizar);

        idnumero1.setText(calculo.getPrimeiroNumero());
        idnumero2.setText(calculo.getSegundoNumero());
        idsimbolo.setText(calculo.getSimboloEscolhido());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idnumero1.setText("");
                idnumero2.setText("");
                idsimbolo.setText("");

            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Aplicativo Finalizado com sucesso", Toast.LENGTH_LONG ).show();
                finish();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outrocalculo.setPrimeiroNumero(idnumero1.getText().toString());
                outrocalculo.setSegundoNumero(idnumero2.getText().toString());
                outrocalculo.setSimboloEscolhido(idsimbolo.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvo com sucesso" + outrocalculo.toString(), Toast.LENGTH_LONG).show();

            }
        });



        Log.i("PooAndroid", calculo.toString());




    }
}