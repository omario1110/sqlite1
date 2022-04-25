package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Ficheproduit extends AppCompatActivity {
    Mydbproduit db;
    TextView t1,t2,t3,t4;
    Spinner sp;
    ArrayList<produit> p ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficheproduit);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        sp=findViewById(R.id.spin);

        db=new Mydbproduit(this);

        p=Mydbproduit.getAllProduits(db.getReadableDatabase());
        ArrayList<String> LISTE=new ArrayList<>();
        for(produit pr : p){
            LISTE.add(String.valueOf(pr.getId()));
        }

        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,LISTE);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                produit pr = p.get(i)  ;
                t1.setText(pr.getLibelle());
                t2.setText(pr.getFamille());
                t3.setText((int) pr.getPrixachat());
                t4.setText((int) pr.getPrixvente());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}