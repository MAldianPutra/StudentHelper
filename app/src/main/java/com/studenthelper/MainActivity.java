package com.studenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.studenthelper.Class.ClassDBHandler;
import com.studenthelper.Class.MainActivity_Class;
import com.studenthelper.Homework.BuildHomework;
import com.studenthelper.Homework.HomeworkDBHandler;
import com.studenthelper.Homework.MainActivity_Homework;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //RecyclerView classRecyclerView;
    //RecyclerView.Adapter classAdapter;
    //ClassDBHandler classDBHandler;
    RecyclerView homeworkRecyclerView;
    RecyclerView.Adapter homeworkAdapter;
    HomeworkDBHandler homeworkDBHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Initialize database
        homeworkDBHandler = new HomeworkDBHandler(this, null, null, 1);

        //Initialize adapter
        homeworkAdapter = new HomeworkAdapter(homeworkDBHandler.getAllHomework(), R.layout.homework_list);
        /*
        classRecyclerView = (RecyclerView) findViewById(R.id.Kelas_list);
        classRecyclerView.setHasFixedSize(true);
        classRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        classRecyclerView.setItemAnimator(new DefaultItemAnimator());
        */
        //classRecyclerView.setAdapter(new );
        homeworkRecyclerView = (RecyclerView) findViewById(R.id.HomeWork_list);
        homeworkRecyclerView.setHasFixedSize(true);
        homeworkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeworkRecyclerView.setItemAnimator(new DefaultItemAnimator());
        homeworkRecyclerView.setAdapter(homeworkAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Menghandle button pindah activity
        if (id == R.id.nav_homework) {
            startActivity(new Intent(MainActivity.this, MainActivity_Homework.class));
        } else if (id == R.id.nav_class) {
            startActivity(new Intent(MainActivity.this, MainActivity_Class.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
