package com.studenthelper.Homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.studenthelper.Class.ClassDBHandler;
import com.studenthelper.MainActivity;
import com.studenthelper.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity_Homework extends AppCompatActivity {
    //xml
    EditText homeworkName;
    EditText classAssign;
    EditText deadlineDate;
    EditText reminderDate;
    RadioGroup statusGroup;
    RadioButton radioButton;
    //database
    HomeworkDBHandler dbHandler;
    ClassDBHandler classDBHandler;
    //alarm
    HomeworkAlarmReceiver alarmReceiver;
    HomeworkAlarmPreference alarmPreference;
    Calendar calOneTimeDate, calOneTimeTime;
    //string text
    String calendarData;
    String radioText;
    Spinner classSpinner;
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
        classSpinner = (Spinner) findViewById(R.id.spinnerClass);

        //alarm
        alarmReceiver = new HomeworkAlarmReceiver();
        alarmPreference = new HomeworkAlarmPreference(this);

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
        //Add class data from db
        classDBHandler = new ClassDBHandler(this,null,null,1);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>
                (MainActivity_Homework.this,
                android.R.layout.simple_spinner_item,
                classDBHandler.getClassName());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(spinnerAdapter);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

        //database
        BuildHomework newHomework = new BuildHomework(hwName, className, deadlineDt, reminderDt, commentTxt);
        dbHandler.addHomework(newHomework);

        //alarm
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String oneTimeDate = dateFormat.format(calOneTimeDate.getTime());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String oneTimeTime = timeFormat.format(calOneTimeTime.getTime());
        alarmPreference.setOneTimeDate(oneTimeDate);
        alarmPreference.setOneTimeMessage(commentTxt);
        alarmPreference.setOneTimeTime(oneTimeTime);
        alarmReceiver.setOneTimeAlarm(this, HomeworkAlarmReceiver.TYPE_ONE_TIME,
                alarmPreference.getOneTimeDate(),
                alarmPreference.getOneTimeTime(),
                alarmPreference.getOneTimeMessage());*/

        //change activity
        startActivity(new Intent(MainActivity_Homework.this, MainActivity.class));
    }
    public void checkIfEmpty(EditText fieldChecked){
        if(fieldChecked.getText().length()==0){
            fieldChecked.setError("Field cannot be left blank");
        }
    }

}
