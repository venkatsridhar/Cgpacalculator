package com.example.venkat.cgpacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by venkat on 10/6/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="student";

    private static final String TABLE_MARKS="marks";
    private static final String TABLE_MARKS1="marks1";

    private static final String KEY_REGNO="regno";
    private static final String KEY_SEM1="sem1";
    private static final String KEY_SEM2="sem2";
    private static final String KEY_SEM3="sem3";
    private static final String KEY_SEM4="sem4";
    private static final String KEY_SEM5="sem5";
    private static final String KEY_SEM6="sem6";




    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
    //    String CREATE_TABLE_2="CREATE TABLE " + TABLE_MARKS1 + "(" + KEY_REGNO + " INTEGER PRIMARY KEY," + KEY_SEM1 + " REAL" + ")";
        //db.execSQL("DROP TABLE IF EXISTS" + TABLE_MARKS);
        //String CREATE_TABLE_1="CREATE TABLE " + TABLE_MARKS + "(" + KEY_REGNO + " INTEGER PRIMARY KEY," + KEY_SEM1 + " REAL," + KEY_SEM2 + " REAL," +
          //      KEY_SEM3 + " REAL," + KEY_SEM4 + " REAL," + KEY_SEM5 + " REAL," + KEY_SEM6 + " REAL" + ")";
        //db.execSQL(CREATE_TABLE_1);
     //   db.execSQL(CREATE_TABLE_2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MARKS);

        onCreate(db);
    }
    public void createtable()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKS);
        String CREATE_TABLE_1="CREATE TABLE " + TABLE_MARKS + "(" + KEY_REGNO + " INTEGER PRIMARY KEY," + KEY_SEM1 + " REAL," + KEY_SEM2 + " REAL," +
                      KEY_SEM3 + " REAL," + KEY_SEM4 + " REAL," + KEY_SEM5 + " REAL," + KEY_SEM6 + " REAL" + ")";
        db.execSQL(CREATE_TABLE_1);
        //String CREATE_TABLE_2="CREATE TABLE " + TABLE_MARKS1 + "(" + KEY_REGNO + " INTEGER PRIMARY KEY," + KEY_SEM1 + " INTEGER" + ")";
        //db.execSQL(CREATE_TABLE_2);
        db.close();
    }
    public void insertRecord(int regno,double s1,double s2,double s3,double s4,double s5,double s6)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_REGNO,regno);
        contentValues.put(KEY_SEM1,s1);
        contentValues.put(KEY_SEM2,s2);
        contentValues.put(KEY_SEM3,s3);
        contentValues.put(KEY_SEM4,s4);
        contentValues.put(KEY_SEM5,s5);
        contentValues.put(KEY_SEM6,s6);
        db.insert(TABLE_MARKS,null,contentValues);
        db.close();
    }


    public double getData(int regno)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] projection={KEY_SEM1,KEY_SEM2,KEY_SEM3,KEY_SEM4,KEY_SEM5,KEY_SEM6};
        //String[] projection={KEY_SEM1};
        String Selection= KEY_REGNO + "=?";
        //String selectionArgs=String.valueOf(regno);
        Cursor c=db.query(TABLE_MARKS,projection,Selection,new String[] {String.valueOf(regno)},null,null,null);
        //Cursor cursor=db.query(TABLE_MARKS1,projection,null,null,null,null,null);
        double res=0;
        if(c.moveToFirst())
        {
                double one=c.getDouble(0);
                double two=c.getDouble(1);
                double three=c.getDouble(2);
                double four=c.getDouble(3);
                double five=c.getDouble(4);
                double six=c.getDouble(5);

            res=one*23+two*23+three*23+four*23;
            res+=five*24+six*24;
            res=res/140;


        }
        return res;

    }



}
