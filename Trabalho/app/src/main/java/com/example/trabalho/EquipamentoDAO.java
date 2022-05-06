package com.example.trabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private static Context context;
    private static Equipamento equipamento;

    public static void inserir(Context context, Equipamento equip){
        Bco conn = new Bco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("modelo", equip.getModelo());
        valores.put("marca", equip.getMarca());
        valores.put("SO", equip.getSO());
        valores.put("preco", equip.getPreco());

        db.insert("equipamento", null, valores);

        db.close();
    }

    public static List<Equipamento> getEquipamentos(Context context){
        Bco conn = new Bco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery( "SELECT modelo, marca, SO, preco FROM equipamento ORDER BY id", null );

        List<Equipamento> lista = new ArrayList<>();

        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            do{
                Equipamento e = new Equipamento();
                e.setMarca(cursor.getString(0));
                e.setModelo(cursor.getString(1));
                e.setSO(cursor.getString(2));
                e.setPreco(cursor.getFloat(3));

                lista.add( e );
            }while (cursor.moveToNext());
        }
        return lista;
    }

}
