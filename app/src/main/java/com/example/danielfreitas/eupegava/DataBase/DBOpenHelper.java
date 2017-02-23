package com.example.danielfreitas.eupegava.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by daniel.freitas on 1/25/17.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    //classe que cria tabelas e banco de dados

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";


    //tabela de usuario
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IDADE_MIN = "age_min";
        public static final String COLUMN_IDADE_MAX = "age_max";
        public static final String COLUMN_PREFERENCIA = "preference";
        public static final String COLUMN_CAMINHO_FOTO = "patch_photo";
    }
    private static final String COMMA_SEP = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";

    private static final String SQL_CREATE_TABLE_USER =
            "CREATE TABLE "+ UserEntry.TABLE_NAME +
            " ("+
                    UserEntry._ID + " INTEGER PRIMARY KEY," +
                    UserEntry.COLUMN_NAME + TEXT_TYPE+ COMMA_SEP +
                    UserEntry.COLUMN_IDADE_MAX + INT_TYPE + COMMA_SEP+
                    UserEntry.COLUMN_IDADE_MIN + INT_TYPE+ COMMA_SEP+
                    UserEntry.COLUMN_PREFERENCIA + INT_TYPE+ COMMA_SEP+
                    UserEntry.COLUMN_CAMINHO_FOTO + TEXT_TYPE+
            " )";


    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
