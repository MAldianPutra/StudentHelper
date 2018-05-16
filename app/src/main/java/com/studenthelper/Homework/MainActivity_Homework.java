package com.studenthelper.Homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.studenthelper.MainActivity;
import com.studenthelper.R;

public class MainActivity_Homework extends AppCompatActivity {
    EditText homeworkName;
    EditText classAssign;
    EditText deadlineDate;
    EditText reminderDate;
    RadioGroup statusGroup;
    RadioButton radioButton;
    HomeworkDBHandler dbHandler;
    String calendarData;
    String radioText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homework);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //xml
        homeworkName = (EditText) findViewById(R.id.homeworkName);
        classAssign = (EditText) findViewById(R.id.classAssign);
        deadlineDate = (EditText) findViewById(R.id.dateAssign);
        reminderDate = (EditText) findViewById(R.id.reminderDate);
        statusGroup = (RadioGroup) findViewById(R.id.statusGroup);

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        calendarData = data.getStringExtra("date");
    }

    public void checkButton(View view){
        int radioId = statusGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        radioText = radioButton.getText().toString();
    }
    public void deadlineClicked(View view){
        Intent intent = new Intent(MainActivity_Homework.this, CalendarActivity_Homework.class);
        startActivityForResult(intent, 1000);
        deadlineDate.setText(calendarData);
    }

    public void reminderClicked(View view){
        Intent intent = new Intent(MainActivity_Homework.this, CalendarActivity_Homework.class);
        startActivityForResult(intent, 1000);
        reminderDate.setText(calendarData);
    }
    public void addHomeworkClicked(View view){
        String hwName = homeworkName.getText().toString();
        String className = classAssign.getText().toString();
        String deadlineDt = deadlineDate.getText().toString();
        String reminderDt = reminderDate.getText().toString();
        String commentTxt = radioText;

        checkIfEmpty(homeworkName);
        checkIfEmpty(classAssign);
        checkIfEmpty(deadlineDate);
        checkIfEmpty(reminderDate);
        if (commentTxt == null){
            commentTxt = "Not Yet";
        }

        BuildHomework newHomework = new BuildHomework(hwName, className, deadlineDt, reminderDt, commentTxt);
        dbHandler.addHomework(newHomework);
        startActivity(new Intent(MainActivity_Homework.this, MainActivity.class));
    }
    public void checkIfEmpty(EditText fieldChecked){
        if(fieldChecked.getText().length()==0){
            fieldChecked.setError("Field cannot be left blank");
        }
    }

}
