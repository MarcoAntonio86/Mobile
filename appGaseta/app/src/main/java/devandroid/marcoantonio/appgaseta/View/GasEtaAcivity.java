package devandroid.marcoantonio.appgaseta.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.marcoantonio.appgaseta.Controller.GasEtaController;
import devandroid.marcoantonio.appgaseta.Model.Gaseta;
import devandroid.marcoantonio.appgaseta.R;
import devandroid.marcoantonio.appgaseta.Util.UtilGaseta;

public class GasEtaAcivity extends AppCompatActivity {
    GasEtaController gasEtaController;

    Gaseta gaseta;

    EditText id_posto;
    EditText id_gasolina;
    EditText id_etanol;
    EditText id_litros;

    Button btn_calcular;
    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        gasEtaController = new GasEtaController(this);
        gasEtaController.toString();

        gaseta = new Gaseta();

        gasEtaController.buscar(gaseta);

        id_posto = findViewById(R.id.id_posto);
        id_gasolina = findViewById(R.id.id_gasolina);
        id_etanol = findViewById(R.id.id_etanol);
        id_litros = findViewById(R.id.id_litros);

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);


       /* btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gaseta.setGasolina(id_gasolina.getText().toString());
                gaseta.setEtanol(id_etanol.getText().toString());
                Toast.makeText((Context) GasEtaAcivity.this, UtilGaseta.calcularMelhorOpcao(3.19, 5.50),
                        Toast.LENGTH_SHORT).show();


            }
        });*/

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_gasolina.setText("");
                id_gasolina.setText("");
                id_etanol.setText("");
                id_litros.setText("");

                gasEtaController.limpar();
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaAcivity.this,"Aplicativo Finalizado com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gaseta.setPosto(id_posto.getText().toString());
                gaseta.setGasolina(id_gasolina.getText().toString());
                gaseta.setEtanol(id_etanol.getText().toString());
                gaseta.setLitros(id_litros.getText().toString());

                Toast.makeText(GasEtaAcivity.this,"Dados Salvos com sucesso" + gaseta.toString(), Toast.LENGTH_LONG).show();

                gasEtaController.salvar(gaseta);
            }
        });

        Log.i("POOAndroid", gaseta.toString());

        // utilGaseta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

        Toast.makeText(GasEtaAcivity.this, UtilGaseta.calcularMelhorOpcao(5.12,3.19),
               Toast.LENGTH_SHORT).show();
    }
}
