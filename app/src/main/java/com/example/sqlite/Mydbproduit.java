package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Mydbproduit extends SQLiteOpenHelper{

    public static String DB_NAME = "produit.db";
    public static String TABLE_NAME = "Produit";
    public static String COL1 = "ID";
    public static String COL2 = "libelle";
    public static String COL3 = "famille";
    public static String COL4 = "prixachat";
    public static String COL5 = "prixvente";

    public Mydbproduit(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+ COL1 +" integer primary key autoincrement, "+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" Text,"+COL5+" Text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
    public static long Insert_produit(SQLiteDatabase sqLiteDatabase,produit p){
       ContentValues content = new ContentValues();
        content.put(COL2, p.getLibelle());
        content.put(COL3, p.getFamille() );
        content.put(COL4, p.getPrixachat());
       content.put(COL5, p.getPrixvente());

        return sqLiteDatabase.insert(TABLE_NAME,null,content);
    }
    public static long updateProduit(SQLiteDatabase sql, produit p){
        ContentValues c = new ContentValues();
        c.put(COL2,p.getLibelle());
        c.put(COL3,p.getFamille());
        c.put(COL4,p.getPrixachat());
        c.put(COL5,p.getPrixvente());
        return sql.update(TABLE_NAME,c,"ID = " + p.getId(),null);
    }
    public static long deleteProduit(SQLiteDatabase sql, int id){
        return sql.delete(TABLE_NAME,"ID = " + id,null);
    }
    public static ArrayList<produit> getAllProduits(SQLiteDatabase sql){
        ArrayList<produit> prds = new ArrayList<>();

        Cursor cur = sql.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        while(cur.moveToNext()){
            produit p = new produit();

            p.setId(cur.getInt(0));
            p.setLibelle(cur.getString(1));
            p.setFamille(cur.getString(2));
            p.setPrixachat(cur.getDouble(3));
            p.setPrixvente(cur.getDouble(4));

            prds.add(p);
        }
        return prds;
    }
    public static produit getAOneProduit(SQLiteDatabase sql, int id){
        produit p = null;

        Cursor cur = sql.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE ID="+id ,null);

        if(cur.moveToNext()){
            p.setId(cur.getInt(0));
            p.setLibelle(cur.getString(1));
            p.setFamille(cur.getString(2));
            p.setPrixachat(cur.getDouble(3));
            p.setPrixvente(cur.getDouble(4));
        }
        return p;
    }

}





