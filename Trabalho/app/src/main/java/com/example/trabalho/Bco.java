package com.example.trabalho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "equipamentos";

    public Bco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS equipamento ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " modelo TEXT NOT NULL," +
                " marca TEXT," +
                " SO TEXT," +
                " preco float);"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
