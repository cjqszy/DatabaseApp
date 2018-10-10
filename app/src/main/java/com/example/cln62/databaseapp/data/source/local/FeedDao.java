package com.example.cln62.databaseapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.cln62.databaseapp.data.source.local.FeedReaderContract.FeedEntry;

import com.example.cln62.databaseapp.data.TodoNote;

public class FeedDao {
    SQLiteDatabase sqLiteDatabase;
    FeedReaderDbHelper feedReaderDbHelper;
    public static String TAG = FeedDao.class.getSimpleName();
    public FeedDao(Context context) {
        feedReaderDbHelper = new FeedReaderDbHelper(context);
    }
    public void openDb() {
        sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
    }

    public void closeDb(){
        sqLiteDatabase.close();
    }

    public void createRow(TodoNote todoNote){
        Log.d(TAG, todoNote.getTitle() + todoNote.getSubTitle());
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, todoNote.getTitle());
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, todoNote.getSubTitle());
        sqLiteDatabase.insert(FeedEntry.TABLE_NAME, null, values );
    }

    public void readRow() {}

    public void updateRow(){}

    public void deleteRow(){}


}
