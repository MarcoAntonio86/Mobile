package devandroid.marcoantonio.appgaseta.View;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.marcoantonio.appgaseta.R;
import devandroid.marcoantonio.appgaseta.Util.UtilGaseta;

public class GasEtaAcivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        // utilGaseta.metodoNaoEstatico();

        //utilGasEta.metodoEstatico();

        Toast.makeText(GasEtaAcivity.this, UtilGaseta.calcularMelhorOpcao(5.12,3.19),
               Toast.LENGTH_SHORT).show();
    }
}
