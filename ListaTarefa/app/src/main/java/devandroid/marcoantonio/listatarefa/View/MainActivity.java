package devandroid.marcoantonio.listatarefa.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.listatarefa.Controller.ListaController;
import devandroid.marcoantonio.listatarefa.Model.Listada;
import devandroid.marcoantonio.listatarefa.R;

public class MainActivity extends AppCompatActivity {

        ListaController controller;
        Listada vlrinserido;


        EditText idinsira;

        Button btnverificar;
        Button btncadastrar;
        Button btnmarcar;
        Button btnexcluir;
        Button btnlistadas;
        Button btnlimpar;
        Button btnsalvar;
        Button btnfinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ListaController(this);
        controller.toString();

        vlrinserido = new Listada();

        controller.buscar(vlrinserido);

        idinsira = findViewById(R.id.idinsira);

        btnverificar = findViewById(R.id.btnverificar);
        btncadastrar = findViewById(R.id.btncadastrar);
        btnmarcar = findViewById(R.id.btnmarcar);
        btnexcluir = findViewById(R.id.btnexcluir);
        btnlistadas = findViewById(R.id.btnlistadas);
        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnfinalizar = findViewById(R.id.btnfinalizar);

        idinsira.setText(vlrinserido.getInsiratarefa());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idinsira.setText("");
                controller.limpar();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlrinserido.setInsiratarefa(idinsira.getText().toString());
                Toast.makeText(MainActivity.this, "Dados Salvos" + vlrinserido.toString(), Toast.LENGTH_LONG).show();
                controller.salvar(vlrinserido);
            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Log.i("POOAndroid", vlrinserido.toString());








    }
}