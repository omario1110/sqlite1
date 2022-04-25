package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listdesproduits extends AppCompatActivity {

    Mydbproduit db;
    ListView liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdesproduits);

        db=new Mydbproduit (this);
        liste=findViewById(R.id.liste);
        ArrayList<produit> prds=Mydbproduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> listeP=new ArrayList<>();
        for(produit p: prds){
            listeP.add(p.getId()+" - "+ p.getLibelle());
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listeP);
        liste.setAdapter(ad);
    }
}