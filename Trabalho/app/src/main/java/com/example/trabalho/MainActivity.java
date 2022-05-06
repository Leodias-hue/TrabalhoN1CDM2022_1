package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listEquipamentos;
    private Button btnAdicionar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listEquipamentos = findViewById(R.id.listEquipamentos);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregaList();
    }

    private void carregaList(){
        List<Equipamento> lista = EquipamentoDAO.getEquipamentos(this);

        if( lista.size() == 0 ){
            Equipamento fake = new Equipamento("Nenhum equipamento cadastrado");
            lista.add( fake );
            listEquipamentos.setEnabled( false );
        }else {
            listEquipamentos.setEnabled( true );
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);
        listEquipamentos.setAdapter( adapter );
    }

}

