package com.example.batches1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.batches1.database.DatabaseHelper;


public class DatabaseHelper7  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mylistfee.db";
    public static final String TABLE_NAME = "my_listfee";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "FEE";
    public static final String COL_4 = "FEETOPAY";

    public DatabaseHelper7(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(NAME TEXT,FEE INTEGER,FEETOPAY INTEGER)");

    }
    public boolean getone(String itemname,String date){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("INSERT INTO my_attendance(NAME,ATTENDANCE,DATE) VALUES ('"+itemname+"','PRESENT','"+date+"')" );
        return true;

    }
    public boolean gettwo(String itemname, String date){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("INSERT  INTO my_attendance(NAME,ATTENDANCE,DATE) VALUES ('"+itemname+"','ABSENT','"+date+"')" );
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String fee, String feetp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COL_2, name);
        contentValue.put(COL_3, fee);
        contentValue.put(COL_4, feetp);

        long result = db.insert(TABLE_NAME, null, contentValue);
        if (result == -1)
            return false;
        else
            return true;


    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM  my_listfee  WHERE FEE=FEETOPAY ", null);
        return data;
    }
    public Cursor getListContentstwo() {
        String sql="SELECT t1.ID, t1.NAME,t1.PHONE FROM my_list2 t1 LEFT JOIN my_list2fee t2 ON t2.NAME=t1.NAME WHERE t2.NAME IS NULL";

        Cursor cursor=getReadableDatabase().rawQuery(sql,null);
        return cursor;
    }
    public Cursor getListContentstthree() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM  my_listfee WHERE FEE<FEETOPAY ", null);
        return data;
    }
}