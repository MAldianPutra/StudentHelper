package com.studenthelper.Homework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.studenthelper.R;

public class MainActivity_Homework extends AppCompatActivity {
    EditText homeworkName;
    EditText classAssign;
    EditText deadlineDate;
    EditText reminderDate;
    EditText commentText;
    Button addHomework;
    HomeworkDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homework);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TextField
        homeworkName = (EditText) findViewById(R.id.homeworkName);
        classAssign = (EditText) findViewById(R.id.classAssign);
        deadlineDate = (EditText) findViewById(R.id.dateAssign);
        reminderDate = (EditText) findViewById(R.id.reminderDate);
        commentText = (EditText) findViewById(R.id.commentText);

        //Create Database
        dbHandler = new HomeworkDBHandler(this, null, null, 1);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addHomeworkClicked(View view){
        String hwName = homeworkName.getText().toString();
        String className = classAssign.getText().toString();
        String deadlineDt = deadlineDate.getText().toString();
        String reminderDt = reminderDate.getText().toString();
        String commentTxt = commentText.getText().toString();

        checkIfEmpty(homeworkName);
        checkIfEmpty(classAssign);
        checkIfEmpty(deadlineDate);
        checkIfEmpty(reminderDate);
        checkIfEmpty(commentText);

        BuildHomework newHomework = new BuildHomework(hwName, className, deadlineDt, reminderDt, commentTxt);
        dbHandler.addHomework(newHomework);
    }
    public void checkIfEmpty(EditText fieldChecked){
        if(fieldChecked.getText().length()==0){
            fieldChecked.setError("Field cannot be left blank");
        }
    }

}
