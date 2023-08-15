package com.example.cricketapplicationn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.PlayerInfoAdapter;
import com.example.cricketapplicationn.Adapter.PlayerInfoFragmentsAdapter;
import com.example.cricketapplicationn.Fragment.PlayerBioFragment;
import com.google.android.material.tabs.TabLayout;

public class PlayerActivity extends AppCompatActivity {
    int  playerId;
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent intent=getIntent();
         playerId=Integer.parseInt(intent.getStringExtra("id"));
       // Toast.makeText(this, playerid2+""+"playerActivuty", Toast.LENGTH_LONG).show();
        //   Bundle bundle = new Bundle();
        // bundle.putInt("playerId",playerId);
        // set Fragmentclass Arguments
        //PlayerBioFragment fragobj = new PlayerBioFragment();
        //fragobj.setArguments(bundle);
        toolbar = findViewById(R.id.toolbar_playerinfo);
        viewPager = findViewById(R.id.viewPager_playerinfo);
        tabLayout = findViewById(R.id.tabLayoutPlayerInfo);
        setSupportActionBar(toolbar);
        // PlayerActivity.this.setTitle();
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new PlayerInfoFragmentsAdapter(getSupportFragmentManager()));
    }

    public Bundle getMyData() {
        Bundle hm = new Bundle();
        hm.putInt("playerId", playerId);
        return hm;
    }
}