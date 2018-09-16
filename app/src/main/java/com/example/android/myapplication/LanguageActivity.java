package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LanguageActivity extends AppCompatActivity {

    String[] mobileArray = {"Java","C++","C#","CSS",
            "HTML","XML",".Net","VisualBasic", "SQL", "Python", "PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.mobile_row_item, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }
}
