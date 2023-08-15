package com.example.cricketapplicationn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.Schhedulefragmentadapter;
import com.example.cricketapplicationn.Model.SereisMatches;
import com.google.android.material.tabs.TabLayout;

public class ScheduleActivity extends AppCompatActivity {
     TabLayout tabLayout;
     int SeriesID;
     ViewPager viewPager;
  ProgressDialog dialog;
     Schhedulefragmentadapter adapter;
     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  getSupportActionBar().hide();


        setContentView(R.layout.activity_schedule);
   dialog=new ProgressDialog(this);
   Intent intent=getIntent();

        SeriesID=intent.getIntExtra("SeriesId",0);
 //       Toast.makeText(this, SeriesID+"", Toast.LENGTH_SHORT).show();
        String SeriesName= intent.getStringExtra("SeriesName");
        tabLayout=findViewById(R.id.tabLayoutSchedule);
      toolbar=findViewById(R.id.toolbarSchedule);
     // toolbar.setTitle();
        setSupportActionBar(toolbar);
        ScheduleActivity.this.setTitle(SeriesName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager=findViewById(R.id.viewPagerSchedule);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScheduleActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        Schhedulefragmentadapter adapter=new Schhedulefragmentadapter(getSupportFragmentManager(),SeriesID);
        viewPager.setAdapter(adapter);

    }

     public Bundle getMyData() {
         Bundle data = new Bundle();
         data.putInt("SeriesId",SeriesID);
         return data;
     }
    }