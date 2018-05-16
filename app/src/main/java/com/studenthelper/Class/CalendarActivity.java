package com.studenthelper.Class;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import com.studenthelper.Homework.MainActivity_Homework;
import com.studenthelper.R;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" + (i1 + 1) + "/" + i2;
                Intent intent = new Intent(CalendarActivity.this, MainActivity_Class.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

    }
}
