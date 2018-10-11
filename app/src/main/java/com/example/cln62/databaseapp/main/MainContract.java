package com.example.cln62.databaseapp.main;

public interface MainContract {
    public interface View {
        // Here the presenter is telling the view(mainActivity)to show a toast.

        public void showToast();
    };

    public interface Presenter{
        // The view is telling the presenter that someone clicked its button, what should it do?
        public void onButtonClicked();
    };
}
