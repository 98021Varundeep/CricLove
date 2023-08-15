package com.example.cricketapplicationn;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import  androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import androidx.support.design.widget.NavigationView;
//import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cricketapplicationn.Fragment.DomesticFragment;
import com.example.cricketapplicationn.Fragment.InternationalFragment;
import com.example.cricketapplicationn.Fragment.LeagueFragment;
import com.example.cricketapplicationn.Fragment.WomenFragment;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class drawerActivity extends AppCompatActivity {
 NavigationView nav;
 List<TypeMatch> list;
 ActionBarDrawerToggle toggle;
 DrawerLayout drawerLayout;
 Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
  Intent intent=getIntent();
 list= (List<TypeMatch>) intent.getSerializableExtra("list");

      toolbar=findViewById(R.id.toolbar_navigation);
      nav=findViewById(R.id.navmenu);
      drawerLayout =findViewById(R.id.drawer);
     //   getSupportActionBar().hide();
          setSupportActionBar(toolbar);
          toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
          drawerLayout.addDrawerListener(toggle);
          toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new InternationalFragment()).commit();
        toolbar.setTitle("International");
        nav.setCheckedItem(R.id.international);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

               Fragment temp;

              public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                  switch (menuItem.getItemId()){
                      case R.id.international:
                          temp=new InternationalFragment();
                          toolbar.setTitle("International Matches");
                        //  Toast.makeText(drawerActivity.this, "International", Toast.LENGTH_SHORT).show();
                          drawerLayout.closeDrawer(GravityCompat.START);
                          break;
                      case R.id.league:
                         temp=new LeagueFragment();
                         toolbar.setTitle("League Matches");
                         // Toast.makeText(drawerActivity.this, "League", Toast.LENGTH_SHORT).show();
                          drawerLayout.closeDrawer(GravityCompat.START);
                          break;
                      case R.id.domestic:
                        temp=new DomesticFragment();
                        toolbar.setTitle("Domestic Matches");
                          //  Toast.makeText(drawerActivity.this, "Domestic", Toast.LENGTH_SHORT).show();
                          drawerLayout.closeDrawer(GravityCompat.START);
                          break;
                      case R.id.women:
                       temp=new WomenFragment();
                       toolbar.setTitle("Women Matches ");
                          //   Toast.makeText(drawerActivity.this, "Women", Toast.LENGTH_SHORT).show();
                          drawerLayout.closeDrawer(GravityCompat.START);
                          break;

                  }
                   getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                     drawerLayout.closeDrawer(GravityCompat.START);
                  return true;
              }
          });

    }

    public Bundle getMyDataInternational() {
        Bundle data = new Bundle();
        data.putSerializable("list",list.get(0));
        return data;
    }

    public Bundle getMyDataDomestic() {
        Bundle data = new Bundle();
        data.putSerializable("list",list.get(2));
        return data;
    }

    public Bundle getMyDataLeague() {
        Bundle data = new Bundle();
        data.putSerializable("list",list.get(1));
        return data;
    }


    public Bundle getMyDataWomen() {
        Bundle data = new Bundle();
        data.putSerializable("list",list.get(3));
        return data;
    }




}