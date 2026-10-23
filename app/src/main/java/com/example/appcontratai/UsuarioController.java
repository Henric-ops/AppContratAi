package com.example.appcontratai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;


public class UsuarioController {

    private conectadb banco;
    private Context contexto;
    private String apaga_usuario;

    public UsuarioController(Context contexto) {
        this.banco = new conectadb(contexto);
        this.contexto = contexto;

    }

    public void insereUsuario(Usuario usr) {

        if (usr.getNome() == null || usr.getNome().trim().isEmpty() || usr.getSenha() == null || usr.getSenha().trim().isEmpty()) {
            Toast.makeText(contexto, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        String INSERE_USUARIO = "INSERT INTO usuario (nome,senha,tipo_usuario) values ('"
                + usr.getNome() + "','" + usr.getSenha() + "','" + usr.getTipo() + "')";
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(INSERE_USUARIO);
            db.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(contexto, "Erro ao inserir usuário:" + ex.getMessage(), Toast.LENGTH_LONG).show();

        }
    }


    public void apaga_usuario(Usuario usr) {
        String apaga_usuario = "DELETE FROM usuario WHERE id =" + usr.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(apaga_usuario);
            db.close();
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
        }
    }

    public void atualiza_usuario(Usuario usr) {
        String ATUALIZA_USUARIO = "UPDATE TABLE usuario SET login = " + usr.getNome() + ", senha =" + usr.getSenha() +
                ", WHERE id = " + usr.getId();
        try {
            SQLiteDatabase db = banco.getWritableDatabase();
            db.execSQL(ATUALIZA_USUARIO);
            db.close();
        } catch (Exception ex) {
            //("Erro (criação tabela)",ex.getMessage());
        }
    }

    public Usuario retornaDadosUsuario(int id) {
        Usuario usr = new Usuario();
        String CONSULTA_USUARIO = "SELECT * FROM usuario where id ='" + id + "'";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);
            if (c.moveToFirst()) {
                do {

                    usr.setId(Integer.parseInt(c.getString(0)));
                    usr.setNome(c.getString(1));
                    usr.setSenha(c.getString(2));
                    usr.setTipo(c.getString(3));

                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return usr;
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }
    }

    public List<Usuario> Consulta_todos_usuarios() {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
        String CONSULTA_USUARIO = "SELECT id,nome,senha,tipo_usuario FROM usuario ORDER BY nome";
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(CONSULTA_USUARIO, null);
            if (c.moveToFirst()) {
                do {
                    Usuario usr = new Usuario();
                    usr.setId(Integer.parseInt(c.getString(0)));
                    usr.setNome(c.getString(1));
                    usr.setSenha(c.getString(2));
                    usr.setTipo(c.getString(3));
                    listaDeUsuarios.add(usr);
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
            return listaDeUsuarios;
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            return null;
        }

    }

    public boolean testaUsuario(String nome) {
        String PESQUISA_POR_NOME = "SELECT id FROM usuario WHERE nome ='" + nome + "'";
        boolean ret = false;
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(PESQUISA_POR_NOME, null);
            int cursorCount = c.getCount();
            c.close();
            if (cursorCount > 0) {
                ret = true;
            }
            banco.close();
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            ret = false;
        }
        return ret;
    }

    public boolean checkUsuario(String nome, String senha) {
        String PESQUISA_POR_NOME_SENHA = "SELECT id  FROM usuario WHERE nome ='" + nome + "' AND senha='" + senha + "'";
        boolean ret = false;
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            Cursor c = bd.rawQuery(PESQUISA_POR_NOME_SENHA, null);
            int cursorCount = c.getCount();
            c.close();
            if (cursorCount > 0) {
                ret = true;
            }
            banco.close();
        } catch (Exception ex) {
            //  ("Erro (criação tabela)",ex.getMessage());
            ret = false;
        }
        return ret;
    }


    public int retornaId() {
        int id = -1;
        try {
            SQLiteDatabase db = banco.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT id FROM usuario ORDER BY id DESC LIMIT 1", null);
            if (((Cursor) c).moveToFirst()) {
                id = c.getInt(0);
            }
            c.close();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
}

