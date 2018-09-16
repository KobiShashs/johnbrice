package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openListViewExample (View view){
        Intent intent = new Intent(this,LanguageActivity.class);
        startActivity(intent);
    }

    public void openRecyclerViewExample (View view){
        Intent intent = new Intent(this,PeopleActivity.class);
        startActivity(intent);
    }

    public void openSqliteExample(View view){
        Intent intent = new Intent(this,DatabaseActivity.class);
        startActivity(intent);
    }
}
