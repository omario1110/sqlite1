package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nouveauproduit extends AppCompatActivity {
    Mydbproduit db;
    EditText e1,e2,e3,e4;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveauproduit);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        //Double pa=
        //Double pv= Double.valueOf(e4.getText().toString());
        bt1=findViewById(R.id.btn1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produit p = new produit();
                p.setId(1);
                p.setLibelle(e1.getText().toString());
                p.setFamille(e2.getText().toString());
                p.setPrixachat(Double.valueOf(e3.getText().toString()));
                p.setPrixvente(Double.valueOf(e4.getText().toString()));
                Mydbproduit.Insert_produit(db.getWritableDatabase(),p);
                if(Mydbproduit.Insert_produit(db.getWritableDatabase(),p)==-1)
                    Toast.makeText(Nouveauproduit.this, "Insertion Echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Nouveauproduit.this, "Insertion OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}