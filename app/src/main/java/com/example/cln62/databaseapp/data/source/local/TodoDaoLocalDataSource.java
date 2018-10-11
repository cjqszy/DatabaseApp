package com.example.cln62.databaseapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cln62.databaseapp.data.source.TodoDataSource;

import com.example.cln62.databaseapp.data.TodoNote;

public class TodoDaoLocalDataSource implements TodoDataSource {
    SQLiteDatabase sqLiteDatabase;
    TodoDbHelper todoDbHelper;
    public static String TAG = TodoDaoLocalDataSource.class.getSimpleName();
    public TodoDaoLocalDataSource(Context context) {
        todoDbHelper = new TodoDbHelper(context);
//        sqLiteDatabase = todoDbHelper.getWritableDatabase();
        openDb();
    }
    public void openDb() {
        sqLiteDatabase = todoDbHelper.getWritableDatabase();
    }

    public void closeDb(){
        sqLiteDatabase.close();
    }

    public void createRow(TodoNote todoNote){
//        Log.d(TAG, todoNote.getTitle() + todoNote.getSubTitle());    // just a test
        ContentValues values = new ContentValues(); // key-value pair
        values.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, todoNote.getTitle());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_SUBTITLE, todoNote.getSubTitle());
        sqLiteDatabase.insert(TodoContract.TodoEntry.TABLE_NAME, null, values ); // that null means if no data being inserted into, will fill with null
    }

    public TodoNote readRow() {
        //first step: read data from database
        // select *  from table_name
        Cursor cursor = sqLiteDatabase.query(TodoContract.TodoEntry.TABLE_NAME, null, null, null,
                    null, null, null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(TodoContract.TodoEntry.COLUMN_NAME_TITLE);
        int subTitleIndex = cursor.getColumnIndexOrThrow(TodoContract.TodoEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String subTitle = cursor.getString(subTitleIndex);

        return new TodoNote(title, subTitle);
    }

    public void updateRow(){}

    public void deleteRow(){}


    @Override
    public void saveTodoNote(TodoNote todoNote) {
        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.COLUMN_NAME_TITLE, todoNote.getTitle());
        values.put(TodoContract.TodoEntry.COLUMN_NAME_SUBTITLE, todoNote.getSubTitle());
        sqLiteDatabase.insert(TodoContract.TodoEntry.TABLE_NAME, null, values );
    }

    @Override
    public void getTodoNote(GetTodoNoteCallback callback) {
        Cursor cursor = sqLiteDatabase.query(TodoContract.TodoEntry.TABLE_NAME, null, null, null,
                null, null, null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(TodoContract.TodoEntry.COLUMN_NAME_TITLE);
        int subTitleIndex = cursor.getColumnIndexOrThrow(TodoContract.TodoEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String subTitle = cursor.getString(subTitleIndex);

        TodoNote todoNote = new TodoNote(title, subTitle);
        callback.onTodoNoteLoaded(todoNote); // this will call MainPresenter line 28
    }
}
