package com.example.batches1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper4 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="mylist4.db";
    public static final String TABLE_NAME="my_list";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="PHONE";

    public static final String TABLE_FEE = "my_listfee";
    public static final String COL_5 = "NAME";
    public static final String COL_6 = "FEE";
    public static final String COL_7 = "FEETOPAY";
    public static final String COL_11 = "DATETOPAY";



    public static final String TABLE_ATTENDENCE = "my_attendance";
    public static final String COL_8 = "NAME";
    public static final String COL_9 = "DATE";
    public static final String COL_10 = "ATTENDANCE";


    public DatabaseHelper4( Context context) {
        super(context, DATABASE_NAME,null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE INTEGER)");
        db.execSQL("CREATE TABLE " + TABLE_FEE + "(NAME TEXT,FEE INTEGER,FEETOPAY INTEGER,DATETOPAY TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_ATTENDENCE + "(NAME TEXT,DATE INTEGER,ATTENDANCE TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FEE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ATTENDENCE);
        onCreate(db);
    }
    public boolean addData(String name,String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue= new ContentValues();
        contentValue.put(COL_2,name);
        contentValue.put(COL_3,phone);

        long result= db.insert(TABLE_NAME,null,contentValue);
        if(result == -1)
            return false;
        else
            return true;


    }

    public boolean addDatafee(String name, String fee, String feetp,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COL_5, name);
        contentValue.put(COL_6, fee);
        contentValue.put(COL_7, feetp);
        contentValue.put(COL_11,date);


        long result = db.insert(TABLE_FEE, null, contentValue);
        if (result == -1)
            return false;
        else
            return true;


    }


    public Cursor getListContents(){
        SQLiteDatabase db =this.getWritableDatabase();
        //db.execSQL("INSERT INTO my_attendance("+COL_8+")SELECT t1.NAME FROM my_list t1  LEFT JOIN my_attendance t2 ON t2.NAME=t1.NAME WHERE t2.NAME IS NULL");
        //db.execSQL("DELETE FROM my_attendance WHERE NAME= (SELECT t2.NAME FROM my_attendance t2  LEFT JOIN my_list t1 ON t1.NAME=t2.NAME WHERE t1.NAME IS NULL)");
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;

    }
    public Cursor getListContentstwo(String date) {
        SQLiteDatabase db =this.getWritableDatabase();
        String sql="SELECT NAME  FROM my_list EXCEPT SELECT NAME FROM my_listfee WHERE "+COL_11+"='"+date+"'";

        Cursor cursor=db.rawQuery(sql,null);
        return cursor;
    }
    public Cursor getListContentsthree(String date) {
        SQLiteDatabase db =this.getWritableDatabase();

        String query = "SELECT NAME FROM my_listfee WHERE FEE=FEETOPAY AND "+COL_11+"='"+date+"'";
        Cursor data = db.rawQuery(query,null);

        return data;

    }

    public Cursor getListContentsfour(){

        SQLiteDatabase db =this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_ATTENDENCE,null);
        return data;

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


    public Cursor getId(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT"+COL_1+"FROM"+TABLE_NAME+"WHERE"+COL_2+"='"+name+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public Cursor present(String name,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT DATE FROM my_attendance WHERE "+COL_8+"='"+name+"' AND ATTENDANCE = 'PRESENT' OR "+COL_9+"='"+date+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public Cursor absent(String name,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT DATE FROM my_attendance WHERE "+COL_8+"='"+name+"' AND ATTENDANCE = 'ABSENT'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public Integer deletedata(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"NAME=?",new String[]{name});
    }
}
