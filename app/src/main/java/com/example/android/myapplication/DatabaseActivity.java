package com.example.android.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText firstNameEditText, lastNameEditText,gradeEditText;
    Button addButton, resButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        databaseHelper = new DatabaseHelper(this);

        firstNameEditText = (EditText)findViewById(R.id.edit_text_fisrt_name);
        lastNameEditText = (EditText)findViewById(R.id.edit_text_last_name);
        gradeEditText = (EditText)findViewById(R.id.edit_text_grade);
        addButton = (Button) findViewById(R.id.button_add);
        resButton=(Button)findViewById(R.id.button_res);
        addData();
        getResult();


    }

    public void addData(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.insertData(firstNameEditText.getText().toString(),
                        lastNameEditText.getText().toString(),
                        Integer.valueOf(gradeEditText.getText().toString()));
                if(isInserted){
                    Toast.makeText(DatabaseActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DatabaseActivity.this, "Ummm..?", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getResult(){
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getAllData();
                if(res.getCount()==0){
                    Toast.makeText(DatabaseActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("NAME :"+res.getString(1)+"\n");
                    buffer.append("LAST :"+res.getString(2)+"\n");
                    buffer.append("GRADE :"+res.getString(3)+"\n\n");


                }

                //Show DATA
                Toast.makeText(DatabaseActivity.this, buffer.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void show(){

    }


    }
