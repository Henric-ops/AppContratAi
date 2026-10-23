package com.example.appcontratai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadPrestador extends AppCompatActivity {

    EditText edtNomeP, edtSenhaP, edtServicoP, edtDescricaoP, edtPrecoP, edtContatoP;
    Button btCadastrarP, btVoltarP;
    Spinner spinCateg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_prestador);

        edtNomeP = findViewById(R.id.edtNomeP);
        edtSenhaP = findViewById(R.id.edtSenhaP);
        edtServicoP = findViewById(R.id.edtServicoP);
        edtDescricaoP = findViewById(R.id.edtDescricaoP);
        edtPrecoP = findViewById(R.id.edtPrecoP);
        edtContatoP = findViewById(R.id.edtContatoP);
        btCadastrarP = findViewById(R.id.btCadastrarP);
        btVoltarP = findViewById(R.id.btVoltarP);
        spinCateg = findViewById(R.id.spinCateg);

        String[] categorias = {"Serviços Gerais", "Alimentação", "Tecnologia", "Frete", "Educação"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        spinCateg.setAdapter(adapter);


        btCadastrarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNomeP.getText().toString().trim();
                String senha = edtSenhaP.getText().toString().trim();
                String servico = edtServicoP.getText().toString().trim();
                String descricao = edtDescricaoP.getText().toString().trim();
                String preco = edtPrecoP.getText().toString().trim();
                String contato = edtContatoP.getText().toString().trim();
                String categoria = spinCateg.getSelectedItem().toString();

                if (nome.isEmpty() || senha.isEmpty() || servico.isEmpty() ||
                        descricao.isEmpty() || preco.isEmpty() || contato.isEmpty()) {
                    Toast.makeText(TelaCadPrestador.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                    return;
                }

                UsuarioController usrctrl = new UsuarioController(TelaCadPrestador.this);

                if (!usrctrl.testaUsuario(nome)) {
                    try {
                        Usuario usr = new Usuario(nome, senha, "Prestador");
                        usrctrl.insereUsuario(usr);

                        int prestId = usrctrl.retornaId();
                        if (prestId == -1) {
                            Toast.makeText(TelaCadPrestador.this, "Erro ao recuperar ID do usuário", Toast.LENGTH_LONG).show();
                            return;
                        }

                        Servico serv = new Servico(prestId, categoria, servico, descricao, preco, contato);
                        ServicoController servctrl = new ServicoController(TelaCadPrestador.this);
                        servctrl.insereServico(serv);

                        Toast.makeText(TelaCadPrestador.this, "Prestador cadastrado com sucesso!", Toast.LENGTH_LONG).show();

                        edtServicoP.setText("");
                        edtDescricaoP.setText("");
                        edtPrecoP.setText("");
                        edtContatoP.setText("");

                    } catch (Exception ex) {
                        Toast.makeText(TelaCadPrestador.this, "Erro ao cadastrar prestador: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(TelaCadPrestador.this, "Usuário já existe!", Toast.LENGTH_LONG).show();
                }
            }
        });


        btVoltarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaCadPrestador.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}