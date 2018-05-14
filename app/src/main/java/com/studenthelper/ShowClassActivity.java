package com.studenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.studenthelper.Class.BuildClass;
import com.studenthelper.Homework.BuildHomework;

public class ShowClassActivity extends AppCompatActivity {

    private boolean fabExpanded = false;
    private FloatingActionButton fabSettings;
    private LinearLayout layoutFabkelas;
    private LinearLayout layoutFabhomework;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabSettings = (FloatingActionButton) findViewById(R.id.fabSetting);
        layoutFabkelas = (LinearLayout) findViewById(R.id.layoutFabClass);
        layoutFabhomework = (LinearLayout) findViewById(R.id.layoutFabHomeWork);
        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabExpanded == true){
                    closeSubMenusFab();
                } else {
                    openSubMenusFab();
                }
            }
        });
        layoutFabkelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowClassActivity.this, BuildClass.class);
                startActivity(intent);
            }
        });
        layoutFabhomework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowClassActivity.this, BuildHomework.class);
                startActivity(intent);
            }
        });
    }

    private void closeSubMenusFab()
    {
        layoutFabkelas.setVisibility(View.INVISIBLE);
        layoutFabhomework.setVisibility(View.INVISIBLE);
        fabSettings.setImageResource(R.drawable.ic_add_white_48dp);
        fabExpanded = false;

    }

    private void openSubMenusFab()
    {
        layoutFabkelas.setVisibility(View.VISIBLE);
        layoutFabhomework.setVisibility(View.VISIBLE);
        //Change settings icon to 'X' icon
        fabSettings.setImageResource(R.drawable.ic_close_black_24dp);
        fabExpanded = true;
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_class, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
