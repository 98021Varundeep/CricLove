package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.SeriesMatch;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InternationalAdapter extends RecyclerView.Adapter<InternationalAdapter.viewHolder> {
    Context context;
    TypeMatch typeMatch;

    public InternationalAdapter(Context context, TypeMatch typeMatch) {
        this.context = context;
        this.typeMatch = typeMatch;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_matchinfo, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        if (typeMatch.seriesMatches.get(position) != null) {

            SeriesMatch seriesMatch = typeMatch.seriesMatches.get(position);

            if (seriesMatch.seriesAdWrapper != null) {
                holder.cardView.setVisibility(View.VISIBLE);
                holder.team1name.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.team1.teamSName);
                holder.team2name.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.team2.teamSName);
                //  holder.team1score.setText(seriesMatch.seriesAdWrapper.matches.get(0).);
                holder.matchBrief.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.matchDesc + "." + seriesMatch.seriesAdWrapper.seriesName);
                holder.matchStatus.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.status);
                holder.matchStatus.setTextColor(ContextCompat.getColor(context, getColorr()));
                Picasso.get()
                        .load("https://countryflagsapi.com/png/" + seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.team1.imageId)
                        .placeholder(R.drawable.ic_baseline_flag_24).into(holder.team1flag);
                Picasso.get().load("https://countryflagsapi.com/png/" + seriesMatch.seriesAdWrapper.matches.get(0).matchInfo.team1.imageId)
                        .placeholder(R.drawable.ic_baseline_flag_24)
                        .into(holder.team2flag);
                if (seriesMatch.seriesAdWrapper.matches.get(0).matchScore != null) {
                    if ((seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score != null && (seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score.inngs1 != null))) {

                        holder.team1score.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score.inngs1.runs + "-" + seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score.inngs1.wickets + " (" + seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score.inngs1.overs + ")");

                        if ((seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score != null && (seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score.inngs1 != null))) {


                            holder.team2score.setText(seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score.inngs1.runs + "-" + seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score.inngs1.wickets + " (" + seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score.inngs1.overs + ")");

                            if (seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team2Score.inngs1.runs > seriesMatch.seriesAdWrapper.matches.get(0).matchScore.team1Score.inngs1.runs) {
                                holder.team2score.setTextColor(ContextCompat.getColor(context, R.color.black));
                                holder.team2name.setTextColor(ContextCompat.getColor(context, R.color.black));
                            } else {
                                holder.team1score.setTextColor(ContextCompat.getColor(context, R.color.black));

                                holder.team1name.setTextColor(ContextCompat.getColor(context, R.color.black));
                            }

                        }

                    }


                }


                holder.schedule.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           Intent intent = new Intent(context, ScheduleActivity.class);
                                                           intent.putExtra("SeriesId", seriesMatch.seriesAdWrapper.seriesId);
                                                           intent.putExtra("SeriesName", seriesMatch.seriesAdWrapper.seriesName);
                                                           context.startActivity(intent);


                                                       }

                                                   }
                );
            } else {
                holder.cardView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                //      CardView.LayoutParams layoutParams= (CardView.LayoutParams) holder.cardView.getLayoutParams();
                //   layoutParams.height=0;
                // layoutParams.width=0;

                //  holder.cardView.setLayoutParams();
                // holder.cardView.setMinimumWidth(0);

                Toast.makeText(context, "SeriesAdwrapper null", Toast.LENGTH_SHORT).show();


            }

        }

    }

    private int getColorr() {
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
        if (typeMatch != null)
            return typeMatch.seriesMatches.size();


        else
            return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView team1name, team2name, team1score, team2score, seriesName, matchBrief,
                matchStatus, schedule;
        ImageView team1flag, team2flag;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView_matchSample);
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
