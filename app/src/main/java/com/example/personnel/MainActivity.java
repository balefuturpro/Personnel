package com.example.personnel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nom , prenom ;
    Button btnSave , btnAfficher ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        btnSave = findViewById(R.id.btnSend);
        btnAfficher = findViewById(R.id.btnAfficher);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database database = new Database(getApplicationContext());
             Boolean result =   database.insert(nom.getText().toString(),prenom.getText().toString());
             if(result==true) {Toast.makeText(MainActivity.this,"Insertion Reussie",Toast.LENGTH_LONG).show();}
             else Toast.makeText(MainActivity.this,"ECHEC Insert",Toast.LENGTH_LONG).show();
             database.close();
            }
        });
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });
    }


}