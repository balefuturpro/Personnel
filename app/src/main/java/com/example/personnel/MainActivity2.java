package com.example.personnel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView Afficher ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Afficher = findViewById(R.id.afficher);
        Affichage();
    }
    public void Affichage() {
        Database db = new Database(getApplicationContext());
        Cursor cursor = db.Afficher();
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
           Afficher.append("nom: "+cursor.getString(1)+" prenom: "+cursor.getString(2)+"\n");
           cursor.moveToNext();
        }

        db.close();
    }
}