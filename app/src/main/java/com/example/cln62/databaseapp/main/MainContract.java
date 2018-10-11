package com.example.cln62.databaseapp.main;

import com.example.cln62.databaseapp.data.TodoNote;

public interface MainContract {

    public interface View {
        // Here the presenter is telling the view(mainActivity)to show a toast.

        public void showTodoNote(TodoNote todoNote);
    };

    public interface Presenter{
        // The view is telling the presenter that someone clicked its button, what should it do?
        public void onButtonClicked();

        void saveNote(TodoNote todoNote1);
    };
}
