package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.Match;
import com.example.cricketapplicationn.Model.MatchDetail;
import com.example.cricketapplicationn.Model.Matchbasicinfo;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.MatchResult;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.viewHolder> {
 static  int i=0;
    Context context;
    List<TypeMatch> list;
 int international;
 int league;
 int domestic;
 int women;

    public RecentAdapter(Context context, List<TypeMatch> list, int international, int league, int domestic, int women) {
        this.context = context;
        this.list = list;
        this.international = international;
        this.league = league;
        this.domestic = domestic;
        this.women = women;
    }

    public RecentAdapter(Context context, List<TypeMatch> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_matchinfo, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
       //  TypeMatch match;
       // Match match2;
  //  TypeMatch    match = list.get(i);

}
  private  int getColorr(){
        List<Integer> ColorCode=new ArrayList<>();
        ColorCode.add(R.color.red);
        ColorCode.add(R.color.blue);
        ColorCode.add(R.color.lightbrown);
       Random random=new Random();
      int randomColor=random.nextInt(ColorCode.size());
      return ColorCode.get(randomColor);
    }
    @Override
    public int getItemCount() {
        return international+9;

    }

class viewHolder extends RecyclerView.ViewHolder {
    TextView team1name, team2name, team1score, team2score, seriesName, matchBrief,
            matchStatus, schedule;
    ImageView team1flag, team2flag;


    public viewHolder(@NonNull View itemView) {
        super(itemView);
        team1name = itemView.findViewById(R.id.teamname1);
        team2name = itemView.findViewById(R.id.teamname2);
        team1score = itemView.findViewById(R.id.team1score);
        team2score = itemView.findViewById(R.id.team2score);
        matchStatus = itemView.findViewById(R.id.matchStatus);
        // seriesName = itemView.findViewById(R.id.seriesName);
        team2flag = itemView.findViewById(R.id.imgteam2);
        team1flag = itemView.findViewById(R.id.imgteam1);
        matchBrief = itemView.findViewById(R.id.matchbrief);
        schedule = itemView.findViewById(R.id.schedule);
    }
}
        }
