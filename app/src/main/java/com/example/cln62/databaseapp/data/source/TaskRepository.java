package com.example.cln62.databaseapp.data.source;

import android.content.Context;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.local.FeedDaoLocalDataSource;

public class TaskRepository implements TaskDataSource{

    TaskDataSource feedDaoLocalDataSource;

    public TaskRepository(Context context) {
        feedDaoLocalDataSource = new FeedDaoLocalDataSource(context);

    }

    @Override
    public void saveTodoNote(TodoNote todoNote) {
        feedDaoLocalDataSource.saveTodoNote(todoNote);
    }
}
