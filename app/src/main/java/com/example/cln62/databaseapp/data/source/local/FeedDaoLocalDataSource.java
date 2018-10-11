package com.example.cln62.databaseapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cln62.databaseapp.data.source.TaskDataSource;
import com.example.cln62.databaseapp.data.source.local.FeedReaderContract.FeedEntry;

import com.example.cln62.databaseapp.data.TodoNote;

public class FeedDaoLocalDataSource implements TaskDataSource{
    SQLiteDatabase sqLiteDatabase;
    FeedReaderDbHelper feedReaderDbHelper;
    public static String TAG = FeedDaoLocalDataSource.class.getSimpleName();
    public FeedDaoLocalDataSource(Context context) {
        feedReaderDbHelper = new FeedReaderDbHelper(context);
        sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
    }
    public void openDb() {
        sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
    }

    public void closeDb(){
        sqLiteDatabase.close();
    }

    public void createRow(TodoNote todoNote){
//        Log.d(TAG, todoNote.getTitle() + todoNote.getSubTitle());    // just a test
        ContentValues values = new ContentValues(); // key-value pair
        values.put(FeedEntry.COLUMN_NAME_TITLE, todoNote.getTitle());
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, todoNote.getSubTitle());
        sqLiteDatabase.insert(FeedEntry.TABLE_NAME, null, values ); // that null means if no data being inserted into, will fill with null
    }

    public TodoNote readRow() {
        //first step: read data from database
        // select *  from table_name
        Cursor cursor = sqLiteDatabase.query(FeedEntry.TABLE_NAME, null, null, null,
                    null, null, null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int subTitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String subTitle = cursor.getString(subTitleIndex);

        return new TodoNote(title, subTitle);
    }

    public void updateRow(){}

    public void deleteRow(){}


    @Override
    public void saveTodoNote(TodoNote todoNote) {
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, todoNote.getTitle());
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, todoNote.getSubTitle());
        sqLiteDatabase.insert(FeedEntry.TABLE_NAME, null, values );
    }
}
