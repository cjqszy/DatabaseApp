package com.example.cln62.databaseapp.data.source;

import android.content.Context;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.local.TodoDaoLocalDataSource;

public class TodoRepository implements TodoDataSource {

    TodoDataSource todoDaoLocalDataSource;

    public TodoRepository(Context context) {
        todoDaoLocalDataSource = new TodoDaoLocalDataSource(context);

    }

    @Override
    public void saveTodoNote(TodoNote todoNote) {
        todoDaoLocalDataSource.saveTodoNote(todoNote);
    }

    @Override
    public void getTodoNote(GetTodoNoteCallback callback) {
        todoDaoLocalDataSource.getTodoNote(callback);
    }
}
