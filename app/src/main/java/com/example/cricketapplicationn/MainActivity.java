package com.example.cricketapplicationn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.FragmentAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.FixtureResponse;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private TabLayout tabLayout;
     private ViewPager viewPager;
  List<TypeMatch> list;
  String getKey;
    private Toolbar toolbar;
    RequestManager manager;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
   MainActivity.this.setTitle("CricLove");
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
           // FragmentAdapter adapter =
               //     adapter=new FragmentAdapter(new FragmentManager );
    tabLayout.setupWithViewPager(viewPager);
 viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

  manager=new RequestManager(this);
   manager.getFixture(listener,"recent");
    }
    private final ResponseListener<FixtureResponse> listener=new ResponseListener<FixtureResponse>() {
        @Override
        public void didError(String Message) {
            Toast.makeText(MainActivity.this, Message, Toast.LENGTH_SHORT).show();
        }

        @Override
          public void didFetch(List<TypeMatch> response, String message) {
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
  list=response;

        }
    };

    public Bundle getMyData() {
        Bundle data = new Bundle();
        data.putSerializable("list", (Serializable) list);
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.changekey,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.key1:
              getKey= String.valueOf(R.string.harsimranApi);
                break;

            case R.id.key2:
                getKey= String.valueOf(R.string.kiran);
                break;

            case R.id.key3:
                getKey= String.valueOf(R.string.varun_);
                break;

            case R.id.key4:
                getKey= String.valueOf(R.string.hitesh);
                break;

            case R.id.key5:
                getKey= String.valueOf(R.string.varun);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
