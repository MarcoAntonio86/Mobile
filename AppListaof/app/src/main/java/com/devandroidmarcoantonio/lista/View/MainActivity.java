package com.devandroidmarcoantonio.lista.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devandroidmarcoantonio.lista.Controller.ListaController;
import com.devandroidmarcoantonio.lista.Model.Lista;
import com.devandroidmarcoantonio.lista.R;

public class MainActivity extends AppCompatActivity {

    ListaController controller;
    Lista lista;

    EditText id_curso;

    Button btn_salvar;
    Button btn_excluir;
    Button btn_limpar;
    Button btn_finalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ListaController(this);
        controller.toString();

        lista = new Lista();

        controller.buscar(lista);

        id_curso = findViewById(R.id.id_curso);
        id_curso.setText(lista.getNomeItem());

        btn_salvar = findViewById(R.id.btn_salvar);
        btn_excluir = findViewById(R.id.btn_excluir);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_curso.setText("");

                controller.limpar();
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Aplicativo Finalizado com Sucesso!!!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            lista.setNomeItem(id_curso.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvos com Sucesso!!!" + lista.toString(),Toast.LENGTH_LONG).show();

                controller.salvar(lista);
            }
        });

        Log.i("POOAndroid", lista.toString());


    }
}