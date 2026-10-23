package com.example.appcontratai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conectadb extends SQLiteOpenHelper {

    String tab_usuario = "CREATE TABLE IF NOT EXISTS usuario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT," +
            "senha TEXT," +
            "tipo_usuario TEXT)";

    String tab_servico = "CREATE TABLE IF NOT EXISTS servico (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "prestador_id INTEGER," +
            "categoria TEXT," +
            "descricao TEXT," +
            "preco TEXT," +
            "contato TEXT)";

    String tab_categoria = "CREATE TABLE IF NOT EXISTS categoria (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome_categoria TEXT)";


    public conectadb(Context contexto) {
        super(contexto, "contrataaidb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tab_usuario);
        db.execSQL(tab_servico);
        db.execSQL(tab_categoria);
        db.execSQL("INSERT INTO categoria (nome_categoria) VALUES ('Serviços Gerais')");
        db.execSQL("INSERT INTO categoria (nome_categoria) VALUES ('Alimentação')");
        db.execSQL("INSERT INTO categoria (nome_categoria) VALUES ('Tecnologia')");
        db.execSQL("INSERT INTO categoria (nome_categoria) VALUES ('Frete')");
        db.execSQL("INSERT INTO categoria (nome_categoria) VALUES ('Educação')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS servico");
        db.execSQL("DROP TABLE IF EXISTS categoria");
        onCreate(db);
    }
}