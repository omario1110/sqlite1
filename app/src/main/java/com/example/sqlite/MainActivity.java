package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Mydbproduit db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // db =new Mydbproduit(this);
       // ArrayList<produit> prds = new ArrayList<>();
        //prds.add(new produit(1,"Produit 1","Liquide",12.4,22));
        //prds.add(new produit(1,"Produit 2","Epicerie",22.4,29));
        //prds.add(new produit(1,"Produit 3","Liquide",15.7,20));
        //prds.add(new produit(1,"Produit 4","Epicerie",14.9,22.4));
        //prds.add(new produit(1,"Produit 5","Liquide",17.4,30));
        //for(produit p : prds)
            //Mydbproduit.Insert_produit(db.getWritableDatabase(),p);

    }



    public void acceder(View view) {
        Intent i= null;
        switch (view.getId()){
            case R.id.btnListe:
                i=new Intent(this,listdesproduits.class);


                        break;
            case R.id.btnFiche:
                i=new Intent(this ,Ficheproduit.class);
                break;
            case R.id.btnPro:
                i=new Intent(this,Nouveauproduit.class);

                break;
            case R.id.btnEdi:
                i=new Intent(this,Editerunproduit.class);
                break;

        }
        startActivity(i);
    }
}