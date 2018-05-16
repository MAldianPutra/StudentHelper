package com.studenthelper.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ClassDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Class.db";
    public static final String TABLE_PRODUCTS = "Homework";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "ClassName";
    public static final String COLUMN_LECTURER = "LecturerName";
    public static final String COLUMN_DAY = "Day";
    public static final String COLUMN_COMMENT = "Comment";

    public ClassDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //Create database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_LECTURER + " TEXT, " +
                COLUMN_DAY + " TEXT, " +
                COLUMN_COMMENT + " TEXT " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    //Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
    }

    //Saat add Class baru
    public void addClass(BuildClass Class){
        ContentValues Values = new ContentValues();
        Values.put(COLUMN_NAME, Class.getClassName());
        Values.put(COLUMN_LECTURER, Class.getLecturerName());
        Values.put(COLUMN_DAY, Class.getDateTime());
        Values.put(COLUMN_COMMENT, Class.getCommentText());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, Values);
        db.close();
    }

    //Delete class, pending dulu
    public void deleteClass(BuildClass buildClass){

    }

    public List<BuildClass> getAllClass(){
        List<BuildClass> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(COLUMN_ID);
            int index2 = cursor.getColumnIndex(COLUMN_NAME);
            int index3 = cursor.getColumnIndex(COLUMN_LECTURER);
            int index4 = cursor.getColumnIndex(COLUMN_DAY);
            int index5 = cursor.getColumnIndex(COLUMN_COMMENT);

            int cid = cursor.getInt(index1);
            String classname = cursor.getString(index2);
            String lecturername = cursor.getString(index3);
            String dayDate = cursor.getString(index4);
            String comment = cursor.getString(index5);
            BuildClass Class = new BuildClass(classname, lecturername, dayDate, comment);
            list.add(Class);
        }
        db.close();
        cursor.close();
        return list;
    }
}
