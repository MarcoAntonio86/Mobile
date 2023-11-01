package devandroid.marcoantonio.cambio.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.marcoantonio.cambio.Model.Cambial;
import devandroid.marcoantonio.cambio.R;

public class MainActivity extends AppCompatActivity {
        Cambial vlrcambio;
        Cambial outrovlrcambial;

        EditText idmoeda1;
        EditText idmoeda2;
        EditText idvalor;
        EditText iddiferenca;

        Button btnlimpar;
        Button btnfinalizar;
        Button btnmaior;
        Button btnmenor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vlrcambio = new Cambial();
        vlrcambio.setMoeda1("Real");
        vlrcambio.setMoeda2("Dolar");
        vlrcambio.setValor("5");
        vlrcambio.setDiferencaCambial("5");

        outrovlrcambial = new Cambial();

        idmoeda1 = findViewById(R.id.idmoeda1);
        idmoeda2 = findViewById(R.id.idmoeda2);
        idvalor = findViewById(R.id.idvalor);
        iddiferenca = findViewById(R.id.iddiferenca);

        btnlimpar = findViewById(R.id.btnlimpar);
        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnmaior = findViewById(R.id.btnmaior);
        btnmenor = findViewById(R.id.btnmenor);

        idmoeda1.setText(vlrcambio.getMoeda1());
        idmoeda2.setText(vlrcambio.getMoeda2());
        idvalor.setText(vlrcambio.getValor());
        iddiferenca.setText(vlrcambio.getDiferencaCambial());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idmoeda1.setText("");
                idmoeda2.setText("");
                idvalor.setText("");
                iddiferenca.setText("");

            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Aplicativo Finalizado com sucesso", Toast.LENGTH_LONG ).show();
                finish();

            }
        });

        Log.i("POOAndroid", vlrcambio.toString());



    }
}