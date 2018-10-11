package com.example.cln62.databaseapp.main;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    public MainPresenter(MainActivity mainActivity) {
        view = mainActivity;
    }

    @Override
    public void onButtonClicked() {
        view.showToast();
    }
}
