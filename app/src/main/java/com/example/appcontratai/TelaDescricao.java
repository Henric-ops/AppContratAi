package com.example.appcontratai;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.speech.tts.TextToSpeechService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaDescricao extends AppCompatActivity {

    TextView txtNome, txtCategoria, txtDescricao, txtPreco, txtContato;
    Button btContratar, btVoltarD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_descricao);

        txtNome = findViewById(R.id.txtNomeServico);
        txtCategoria = findViewById(R.id.txtCategoriaServico);
        txtDescricao = findViewById(R.id.txtDescricaoServico);
        txtPreco = findViewById(R.id.txtPrecoServico);
        txtContato = findViewById(R.id.txtContatoServico);


        Intent i = getIntent();
        int servicoId = i.getIntExtra("servicoId", -1);

        if (servicoId != -1) {
            ServicoController servCtrl = new ServicoController(this);
            Servico serv = servCtrl.retornaServico(servicoId);
            txtNome.setText(serv.getNomeServico());
            txtDescricao.setText(serv.getDescricao());
            txtPreco.setText(serv.getPreco());
            txtContato.setText(serv.getContato());


        }

        btContratar = findViewById(R.id.btContratar);
        btContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TelaDescricao.this,"Serviço contratado!", LENGTH_LONG).show();

            }
        });

        btVoltarD = findViewById(R.id.btVoltaD);
        btVoltarD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaDescricao.this,TelaPrincipal.class);
                startActivity(i);
            }
        });
    }
}