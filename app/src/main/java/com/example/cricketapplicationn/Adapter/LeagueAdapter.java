package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.viewHolder>{

    Context context;
     TypeMatch typeMatch;

    public LeagueAdapter(Context context, TypeMatch typeMatch) {
        this.context = context;
        this.typeMatch = typeMatch;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_matchinfo,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    private  int getColorr() {
        List<Integer> ColorCode = new ArrayList<>();
        ColorCode.add(R.color.red);
        ColorCode.add(R.color.blue);
        ColorCode.add(R.color.lightbrown);
        Random random = new Random();
        int randomColor = random.nextInt(ColorCode.size());
        return ColorCode.get(randomColor);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder{

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
