package com.example.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyDAO {
    private Context context;
    private SQLiteDatabase database;
    public MyDAO(Context context){
        this.context=context;

        MyDBhelper dBhelper =new MyDBhelper(context,"JOJO'sDatebase",null,1);
        database=dBhelper.getReadableDatabase();
    }

    public Uri DAOinsert(ContentValues contentValues){
        long rowid=database.insert("student",null,contentValues);

        Uri uri=Uri.parse("content://JOJO.provider2/student");
        Uri inserturi= ContentUris.withAppendedId(uri,rowid);
        context.getContentResolver().notifyChange(inserturi,null);
        return inserturi;
    }
}