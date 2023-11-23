package devandroid.marcoantonio.appgaseta.View;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.marcoantonio.appgaseta.Controller.GasEtaController;
import devandroid.marcoantonio.appgaseta.Model.Combustivel;
import devandroid.marcoantonio.appgaseta.Model.Gaseta;
import devandroid.marcoantonio.appgaseta.R;
import devandroid.marcoantonio.appgaseta.Util.UtilGaseta;

public class GasEtaAcivity extends AppCompatActivity {


    GasEtaController gasEtaController;

    Gaseta gaseta;

    Combustivel combustivelEtanol;
    Combustivel combustivelGasolina;


    EditText id_posto;
    EditText id_gasolina;
    EditText id_etanol;


    Button btn_calcular;
    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    TextView id_resultado;

    double precoEtanol;
    double precoGasolina;
    String recomendacao;

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

        btn_calcular = findViewById(R.id.btn_calcular);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        id_resultado = findViewById(R.id.id_resultado);

        id_posto.setText(gaseta.getPosto());
        id_gasolina.setText(gaseta.getGasolina());
        id_etanol.setText(gaseta.getEtanol());



        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(id_etanol.getText())) {
                    id_etanol.setError("Obrigatorio");
                    id_etanol.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(id_gasolina.getText())) {
                    id_gasolina.setError("Obrigatorio");
                    id_gasolina.requestFocus();
                    isDadosOk = false;
                }
                if (isDadosOk) {
                    precoGasolina = Double.parseDouble(id_gasolina.getText().toString());
                    precoEtanol = Double.parseDouble(id_etanol.getText().toString());
                    recomendacao = UtilGaseta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    id_resultado.setText(recomendacao);

                    btn_salvar.setEnabled(true);
                }
                else {
                    Toast.makeText(GasEtaAcivity.this, "Dados Obrigatórios !!", Toast.LENGTH_SHORT).show();

                    btn_salvar.setEnabled(false);
                }
            }
        });
        // TODO: desbilitar o botão salvar
        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_posto.setText("");
                id_gasolina.setText("");
                id_etanol.setText("");

                btn_salvar.setEnabled(false);


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

                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();


                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGaseta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGaseta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                gaseta.setPosto(id_posto.getText().toString());
                gaseta.setGasolina(id_gasolina.getText().toString());
                gaseta.setEtanol(id_etanol.getText().toString());
                  Toast.makeText(GasEtaAcivity.this,"Dados Salvos com sucesso" + gaseta.toString(), Toast.LENGTH_LONG).show();

                gasEtaController.salvar(gaseta);
            }
        });

        Log.i("POOAndroid", gaseta.toString());

        // utilGaseta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

       /* Toast.makeText(GasEtaAcivity.this, UtilGaseta.calcularMelhorOpcao(5.12,3.19),
               Toast.LENGTH_SHORT).show();*/
    }
}
