package com.studenthelper.Class;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.studenthelper.R;

public class CalendarActivity_Class extends AppCompatActivity {

    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String date = day + "/" + (month + 1) + "/" + year;
                Intent intent = new Intent(CalendarActivity_Class.this, MainActivity_Class.class);
                intent.putExtra("date", date);
                setResult(1000, intent);
                finish();
            }
        });
    }

}
