package com.example.cln62.databaseapp.main;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.TaskDataSource;
import com.example.cln62.databaseapp.data.source.TaskRepository;

public class MainPresenter implements MainContract.Presenter, TaskDataSource.GetTodoNoteCallback {
    MainContract.View view;
    TaskDataSource taskRepository;

    public MainPresenter(MainActivity mainActivity) {
        view = mainActivity;
        taskRepository = new TaskRepository(mainActivity);
    }

    @Override
    public void onButtonClicked() {
        taskRepository.getTodoNote(this); // from here to line 28
    }

    @Override
    public void saveNote(TodoNote todoNote1) {
        taskRepository.saveTodoNote(todoNote1);
    }

    @Override
    public void onTodoNoteLoaded(TodoNote todoNote) {
        view.showTodoNote(todoNote);
    }
}
