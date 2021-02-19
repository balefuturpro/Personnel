package com.example.personnel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String nom_base = "Personnel.db";
    public static final String table = "Personne";
    public String query = "CREATE TABLE Personne (idpers integer primary key autoincrement,nom String , prenom String)";
    public Database (Context context) {
      super(context,nom_base,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(String nom,String prenom) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom",nom);
        contentValues.put("prenom",prenom);

       long resultat =  db.insert(table,null,contentValues);
       if (resultat == -1) {
           return false;
       } else return true ;

    }
    public Cursor Afficher() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM Personne",null);
        return result ;

    }
}
