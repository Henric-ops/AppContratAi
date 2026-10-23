package com.example.appcontratai;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appcontratai.Servico;
import com.example.appcontratai.conectadb;

import java.util.ArrayList;
import java.util.List;

public class ServicoController {

    private conectadb banco;
    private Context contexto;


    protected ServicoController(Context contexto) {

        this.contexto = contexto;
        banco = new conectadb(contexto);
    }

    public void insereServico(Servico serv) {

        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            String INSERE_SERVICO = "INSERT INTO servico (prestador_id, categoria, descricao, preco,contato) VALUES ('"
                    + serv.getPrestadorId() + "','" + serv.getCategoria() + "','"
                    + serv.getDescricao() + "','" + serv.getPreco() + "','" + serv.getContato() + "')";

            bd.execSQL(INSERE_SERVICO);
            bd.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
    public List<Servico> listarTodosServicos() {
        List<Servico> lista = new ArrayList<>();

        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            String sql = "SELECT id, prestador_id, categoria, descricao, preco,contato FROM servico";
            Cursor c = bd.rawQuery(sql, null);

            if (c.moveToFirst()) {
                do {
                    Servico serv = new Servico();
                    serv.setId(c.getInt(0));
                    serv.setPrestadorId(c.getInt(1));
                    serv.setCategoria(c.getString(2));
                    serv.setDescricao(c.getString(3));
                    serv.setPreco(c.getString(4));
                    serv.setContato(c.getString(5));

                    lista.add(serv);
                } while (c.moveToNext());
            }

            c.close();
            bd.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    public List<Servico> listarServicosPorCategoria(String categoria) {
        List<Servico> lista = new ArrayList<>();

        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            String sql = "SELECT id, prestador_id, categoria, descricao, preco, contato FROM servico WHERE categoria = ?";
            Cursor c = bd.rawQuery(sql, new String[]{categoria});

            if (c.moveToFirst()) {
                do {
                    Servico serv = new Servico();
                    serv.setId(c.getInt(0));
                    serv.setPrestadorId(c.getInt(1));
                    serv.setCategoria(c.getString(2));
                    serv.setDescricao(c.getString(3));
                    serv.setPreco(c.getString(4));
                    serv.setContato(c.getString(5));

                    lista.add(serv);
                } while (c.moveToNext());
            }

            c.close();
            bd.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public Servico retornaServico(int id) {
        Servico serv = null;
        try {
            SQLiteDatabase bd = banco.getReadableDatabase();
            String sql = "SELECT id, prestador_id, categoria, descricao, preco,contato FROM servico WHERE id = ?";
            Cursor c = bd.rawQuery(sql, new String[]{String.valueOf(id)});

            if (c.moveToFirst()) {
                serv = new Servico();
                serv.setId(c.getInt(0));
                serv.setPrestadorId(c.getInt(1));
                serv.setCategoria(c.getString(2));
                serv.setDescricao(c.getString(3));
                serv.setPreco(c.getString(4));
                serv.setContato(c.getString(5));

            }

            c.close();
            bd.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return serv;
    }



}
