package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Editerunproduit extends AppCompatActivity {
    Mydbproduit db;
    EditText e1,e2,e3,e4;
    Spinner sp;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editerunproduit);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        sp=findViewById(R.id.spin);
        btn1=findViewById(R.id.edit);
        db=new Mydbproduit(this);
        ArrayList<produit> p = new ArrayList<>();
        p=Mydbproduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> LISTE=new ArrayList<>();
        for(produit pr : p){
            LISTE.add(String.valueOf(pr.getId()));
        }

        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,LISTE);
        sp.setAdapter(ad);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produit p = new produit();

                p.setLibelle(e1.getText().toString());
                p.setFamille(e2.getText().toString());
                p.setPrixachat(Double.valueOf(e3.getText().toString()));
                p.setPrixvente(Double.valueOf(e4.getText().toString()));
                Mydbproduit.updateProduit(db.getWritableDatabase(),p);
            }
        });
    }
}