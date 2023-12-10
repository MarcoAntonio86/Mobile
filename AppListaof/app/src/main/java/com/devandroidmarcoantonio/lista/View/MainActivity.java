package com.devandroidmarcoantonio.lista.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.devandroidmarcoantonio.lista.Controller.ListaController;
import com.devandroidmarcoantonio.lista.Model.Lista;
import com.devandroidmarcoantonio.lista.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListaController controller;
    Lista lista;

    EditText id_curso;

    Button btn_salvar;
    Button btn_excluir;
    Button btn_limpar;
    Button btn_finalizar;
    Button btn_atualizar;

    Spinner spinner;

    List<String> spinnerItems = new ArrayList<>();

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
        btn_atualizar = findViewById(R.id.btn_atualizar);



        spinner = findViewById(R.id.spinner);


        List<String> itensDoBanco = controller.obterItensDoBanco();
        spinnerItems.addAll(itensDoBanco);


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







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
                String novoItem = id_curso.getText().toString();
                lista.setNomeItem(novoItem);


                spinnerItems.add(novoItem);


                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_item, spinnerItems);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);


                id_curso.setText("");


                Toast.makeText(MainActivity.this, "Dados Salvos com Sucesso!!!", Toast.LENGTH_LONG).show();


                controller.salvar(lista);
            }
        });



        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String selectedItem = spinner.getSelectedItem().toString();


                spinnerItems.remove(selectedItem);


                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_item, spinnerItems);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);


                controller.excluirItemDoBanco(selectedItem);

                Toast.makeText(MainActivity.this, "Item excluído: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });



        btn_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spinner.getSelectedItem() != null) {

                    String itemAntigo = spinner.getSelectedItem().toString();


                    id_curso.setText(itemAntigo);


                    spinnerItems.remove(itemAntigo);


                    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this,
                            android.R.layout.simple_spinner_item, spinnerItems);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(spinnerAdapter);


                    controller.excluirItemDoBanco(itemAntigo);
                } else {

                    Toast.makeText(MainActivity.this, "Selecione um item para atualizar.", Toast.LENGTH_LONG).show();
                }
            }
        });





        Log.i("POOAndroid", lista.toString());


    }

    private void atualizarDados() {

        String itemAntigo = spinner.getSelectedItem().toString();


        String itemNovo = id_curso.getText().toString();


        if (!itemAntigo.equals(itemNovo)) {

            controller.atualizarItemNoBanco(itemAntigo, itemNovo);


            int indiceItemAntigo = spinnerItems.indexOf(itemAntigo);
            if (indiceItemAntigo != -1) {
                // Remover o item antigo da lista e adicionar o novo item
                spinnerItems.remove(indiceItemAntigo);
                spinnerItems.add(indiceItemAntigo, itemNovo);


                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_item, spinnerItems);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);

                spinner.setSelection(indiceItemAntigo);
            }


            id_curso.setText("");


            Toast.makeText(MainActivity.this, "Dados Atualizados com Sucesso!!!", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(MainActivity.this, "Os itens são iguais. Nenhuma atualização realizada.", Toast.LENGTH_LONG).show();
        }
    }





}