package com.example.appcontratai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSenha;
    Button btLogin,btCad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSenha = findViewById(R.id.edtSenha);
        btLogin = findViewById(R.id.btLogin);
        btCad = findViewById(R.id.btCad);

        btCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TelaCadastro.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                if (nome.isEmpty() || senha.isEmpty()){
                    Toast.makeText(MainActivity.this,"Preencha todos os campos", Toast.LENGTH_LONG).show();
                    return;
                }

                UsuarioController ctrl = new UsuarioController(MainActivity.this);
                boolean validar = ctrl.checkUsuario(nome,senha);

                if (validar) {
                    Toast.makeText(MainActivity.this,"Login realizado", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,TelaPrincipal.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"Usuário ou senha incorretos", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}