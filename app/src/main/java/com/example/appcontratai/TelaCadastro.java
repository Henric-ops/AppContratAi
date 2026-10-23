package com.example.appcontratai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText edtNomeC, edtSenhaC;
    Button btCadastra, btVoltar;
    RadioButton radPrest, radCotra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edtNomeC = findViewById(R.id.edtNomeC);
        edtSenhaC = findViewById(R.id.edtSenhaC);
        btCadastra = findViewById(R.id.btCadastra);
        btVoltar = findViewById(R.id.btVoltar);
        radCotra = findViewById(R.id.radContra);
        radPrest = findViewById(R.id.radPrest);

        radPrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaCadastro.this, TelaCadPrestador.class);
                startActivity(i);
            }
        });

        btCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNomeC.getText().toString().trim();
                String senha = edtSenhaC.getText().toString().trim();

                if (nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(TelaCadastro.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!radCotra.isChecked() && !radPrest.isChecked()) {
                    Toast.makeText(TelaCadastro.this, "Selecione um tipo de usuário", Toast.LENGTH_LONG).show();
                    return;
                }

                if (radCotra.isChecked()) {
                    UsuarioController ctrl = new UsuarioController(TelaCadastro.this);

                    if (!ctrl.testaUsuario(nome)) {
                        Usuario usr = new Usuario(nome, senha, "Contratante");
                        ctrl.insereUsuario(usr);
                        Toast.makeText(TelaCadastro.this, "Usuário cadastrado!", Toast.LENGTH_LONG).show();
                        edtNomeC.setText("");
                        edtSenhaC.setText("");
                    } else {
                        Toast.makeText(TelaCadastro.this, "Usuário já existe", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Intent i = new Intent(TelaCadastro.this, TelaCadPrestador.class);
                    startActivity(i);
                }
            }
        });


        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadastro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}