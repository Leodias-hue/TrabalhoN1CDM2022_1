package com.example.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CadastrarActivity extends AppCompatActivity {
    private RadioGroup spSO;
    private EditText etModelo, etMarca, editPreco;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        spSO = findViewById(R.id.idGroup);
        etModelo = findViewById(R.id.etModelo);
        etMarca = findViewById(R.id.etMarca);
        btnSalvar = findViewById(R.id.btnSalvar);
        editPreco = findViewById(R.id.editPreco);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                String preco = editPreco.getText().toString();
                int radioid = spSO.getCheckedRadioButtonId();


                if ( radioid != -1 && !marca.matches("") && !preco.matches("") && !modelo.matches("")) {


                    Float valor = Float.valueOf(preco);
                    RadioButton radioButton = findViewById(radioid);
                    String radioText = radioButton.getText().toString();
                    Equipamento equip = new Equipamento(marca, modelo,radioText,valor);
                    EquipamentoDAO.inserir(CadastrarActivity.this,equip);
                    Intent intent = new Intent(CadastrarActivity.this, MainActivity.class);
                    intent.putExtra("acao", "listar");
                    startActivity(intent);

                }

            }
        });

    }

}
