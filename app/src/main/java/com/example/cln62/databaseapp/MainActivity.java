package com.example.cln62.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.local.FeedDao;

public class MainActivity extends AppCompatActivity {
    EditText titleEditText, subtitleEditText;
    FeedDao feedDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleEditText = findViewById(R.id.editTextTitle);
        subtitleEditText = findViewById(R.id.editTextSubTitle);
        feedDao = new FeedDao(this);
        feedDao.openDb();
    }

    public void clickHandler(View view) {
        switch (view.getId()) {
            case R.id.buttonGet :
                break;
            case R.id.buttonPut :
                String title = titleEditText.getText().toString();
                String subTitle = subtitleEditText.getText().toString();
                TodoNote todoNote = new TodoNote(title, subTitle);
                feedDao.createRow(todoNote);
                titleEditText.setText("");
                subtitleEditText.setText("");
                break;
        }
    }
}
