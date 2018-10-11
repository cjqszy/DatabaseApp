package com.example.cln62.databaseapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cln62.databaseapp.R;
import com.example.cln62.databaseapp.data.TodoNote;
import com.example.cln62.databaseapp.data.source.local.FeedDao;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    EditText titleEditText, subtitleEditText;
    FeedDao feedDao;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleEditText = findViewById(R.id.editTextTitle);
        subtitleEditText = findViewById(R.id.editTextSubTitle);
        feedDao = new FeedDao(this);
        feedDao.openDb();
        mainPresenter = new MainPresenter(this);
    }

    public void clickHandler(View view) {
        switch (view.getId()) {
            case R.id.buttonGet :
                TodoNote todoNote = feedDao.readRow();
                TextView textView = findViewById(R.id.textView);
                textView.setText(todoNote.getTitle() + "\n" + todoNote.getSubTitle());
                break;
            case R.id.buttonPut :
                String title = titleEditText.getText().toString();
                String subTitle = subtitleEditText.getText().toString();
                TodoNote todoNote1 = new TodoNote(title, subTitle);
                feedDao.createRow(todoNote1);
                titleEditText.setText("");
                subtitleEditText.setText("");
                break;
            case R.id.buttonMvp :
                mainPresenter.onButtonClicked();
                break;

        }
    }

    @Override
    public void showToast() {
        Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
    }
}
