package com.studenthelper.Class;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.studenthelper.MainActivity;
import com.studenthelper.R;

public class MainActivity_Class extends AppCompatActivity {

    EditText className;
    EditText lecturerName;
    EditText dateTime;
    EditText commentText;
    ClassDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Textfield
        className = (EditText) findViewById(R.id.className);
        lecturerName = (EditText) findViewById(R.id.lecturerName);
        dateTime = (EditText) findViewById(R.id. dateTime) ;
        commentText = (EditText) findViewById(R.id.commentText);
        //Database
        dbHandler = new ClassDBHandler(this, null, null, 1);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addClassClicked(View view){
        String sClass = className.getText().toString();
        String sLecturer = lecturerName.getText().toString();
        String sDate = dateTime.getText().toString();
        String sComment = commentText.getText().toString();

        checkIfEmpty(className);
        checkIfEmpty(lecturerName);
        checkIfEmpty(dateTime);
        checkIfEmpty(commentText);

        BuildClass buildClass = new BuildClass(sClass, sLecturer, sDate, sComment);
        dbHandler.addClass(buildClass);
        startActivity(new Intent(MainActivity_Class.this, MainActivity.class));
    }

    public void checkIfEmpty(EditText fieldChecked){
        if(fieldChecked.getText().length()==0){
            fieldChecked.setError("Field cannot be left blank");
        }
    }

}
