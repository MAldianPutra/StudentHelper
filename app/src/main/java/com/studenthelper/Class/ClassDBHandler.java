package com.studenthelper.Class;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Class.db";
    //public static final String TABLE_PRODUCTS = "products";
    //public static final String COLUMN_ID = "_id";
    //public static final String COLUMN_PRODUCTNAME = "productname";

    public ClassDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //Create database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Saat add Class baru
    public void addClass(BuildClass buildClass){

    }

    //Delete class, pending dulu
    //public void deleteClass(String)

    //menampilkan hasil database
    public String ClassDBToString(){
        String dbString = "";
        return dbString;
    }
}
