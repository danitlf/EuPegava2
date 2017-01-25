package com.example.danielfreitas.eupegava.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daniel.freitas on 1/25/17.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    //classe que cria tabelas e banco de dados

    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "DataBase";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
