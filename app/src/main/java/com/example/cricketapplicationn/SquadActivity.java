package com.example.cricketapplicationn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.PlayersAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.Player;

import java.util.List;

public class SquadActivity extends AppCompatActivity {
Toolbar  toolbar;
 RecyclerView recyclerView;
 RequestManager manager;
 int seriesid;
 String teamName;
 int squadid;
 ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_squad);
        toolbar=findViewById(R.id.toolbar_player);
        setSupportActionBar(toolbar);
  recyclerView=findViewById(R.id.recycler_player);
  seriesid=getIntent().getIntExtra("SeriesId",0);
  squadid=getIntent().getIntExtra("TeamId",0);
 teamName=getIntent().getStringExtra("TeamName");
        SquadActivity.this.setTitle(teamName);

        dialog=new ProgressDialog(this);
 manager=new RequestManager(this);
 manager.getpllayers(listener,seriesid,squadid);



    }
 private final PlayerListener listener=new PlayerListener() {
     @Override
     public void didFetch(List<Player> list, String message) {
         dialog.dismiss();
         if(list==null){
             Toast.makeText(SquadActivity.this, "Can not Load Data,Eroor", Toast.LENGTH_SHORT).show();
         }
         else{

             recyclerView.setLayoutManager(new LinearLayoutManager(SquadActivity.this));
             PlayersAdapter adapter=new PlayersAdapter(SquadActivity.this,list);
              recyclerView.setHasFixedSize(true);
              recyclerView.setAdapter(adapter);
         }
     }

     @Override
     public void didError(String message) {
         Toast.makeText(SquadActivity.this,message, Toast.LENGTH_SHORT).show();
     }
 };
}