package com.example.cln62.databaseapp.main;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.TaskDataSource;
import com.example.cln62.databaseapp.data.source.TaskRepository;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    TaskDataSource taskRepository;

    public MainPresenter(MainActivity mainActivity) {
        view = mainActivity;
        taskRepository = new TaskRepository(mainActivity);
    }

    @Override
    public void onButtonClicked() {
        view.showToast();
    }

    @Override
    public void saveNote(TodoNote todoNote1) {
        taskRepository.saveTodoNote(todoNote1);
    }
}
