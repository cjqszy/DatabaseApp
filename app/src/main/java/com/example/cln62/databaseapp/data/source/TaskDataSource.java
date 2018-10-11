package com.example.cln62.databaseapp.data.source;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.main.MainPresenter;

public interface TaskDataSource {

    public void saveTodoNote(TodoNote todoNote);

    void getTodoNote(GetTodoNoteCallback callback);

    public interface GetTodoNoteCallback{
        void onTodoNoteLoaded(TodoNote todoNote);
    };
}
