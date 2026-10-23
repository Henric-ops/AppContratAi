package com.example.appcontratai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TelaPrincipal extends AppCompatActivity {

   LinearLayout btTec, btServico, btFrete, btAlimento, btEduc;
   Button btVoltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btTec = findViewById(R.id.btTec);
        btServico = findViewById(R.id.btServico);
        btFrete = findViewById(R.id.btFrete);
        btAlimento = findViewById(R.id.btAlimento);
        btEduc = findViewById(R.id.btEduc);
        btVoltarMenu = findViewById(R.id.btVoltaMenu);

        btTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this, TelaListaServicos.class);
                i.putExtra("categoria","Tecnologia");
                startActivity(i);
            }
        });

        btServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this, TelaListaServicos.class);
                i.putExtra("categoria","Serviços Gerais");
                startActivity(i);
            }
        });

        btFrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this, TelaListaServicos.class);
                i.putExtra("categoria","Frete");
                startActivity(i);
            }
        });

        btAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this, TelaListaServicos.class);
                i.putExtra("categoria","Alimentação");
                startActivity(i);
            }
        });

        btEduc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this, TelaListaServicos.class);
                i.putExtra("categoria","Educação");
                startActivity(i);
            }
        });

        btVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipal.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}