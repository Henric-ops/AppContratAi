package com.example.appcontratai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class TelaListaServicos extends AppCompatActivity {

    ListView listaServicos;
    ServicoController servCtrl;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_servicos);

        listaServicos = findViewById(R.id.listaServicos);
        servCtrl = new ServicoController(this);


        String categ = getIntent().getStringExtra("categoria");
        List<Servico> lista = servCtrl.listarServicosPorCategoria(categ);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (Servico s : lista) {
            adapter.add(s.getDescricao() + " - R$ " + s.getPreco());
        }

        listaServicos.setAdapter(adapter);

        listaServicos.setOnItemClickListener((parent, view, position, id) -> {
            Servico servico = lista.get(position);
            Intent i = new Intent(TelaListaServicos.this, TelaDescricao.class);
            i.putExtra("servicoId", servico.getId());
            startActivity(i);
        });
    }
}