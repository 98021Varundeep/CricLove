package com.example.cricketapplicationn.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.Match;
import com.example.cricketapplicationn.Model.MatchDetail;
import com.example.cricketapplicationn.Model.MatchDetailsMap;
import com.example.cricketapplicationn.Model.Matchbasicinfo;
import com.example.cricketapplicationn.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.viewHolder> {
    static int i = 0;
    Context context;
    List<MatchDetail> list;
    Match match;

    public MatchesAdapter(Context context, List<MatchDetail> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.matchschedule, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {


        final MatchDetail matchDetail = list.get(position);
//        holder.seriesName.setText(list.get(position).matchDetailsMap.match.get(0).matchInfo.seriesName);


        final MatchDetailsMap matchDetailsMap = matchDetail.matchDetailsMap;
        if (matchDetailsMap == null) {
  //          hideView(holder.rootView);
           // holder.rootView.setVisibility(View.GONE);
    //        holder.cardView.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
            //      holder.cardView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            //       holder.cardView.setLayoutParams(new ViewGroup.LayoutParams(0,0));
            /*
            holder.matchBrief.setVisibility(View.GONE);
            holder.dateAndTime.setVisibility(View.GONE);
            holder.team2name.setVisibility(View.GONE);
            holder.team1name.setVisibility(View.GONE);
            holder.team2score.setVisibility(View.GONE);
            holder.team1score.setVisibility(View.GONE);
            holder.team1flag.setVisibility(View.GONE);
            holder.team2flag.setVisibility(View.GONE);
            holder.matchStatus.setVisibility(View.GONE);
*/
        } else {
            match = matchDetailsMap.match.get(0);
//
            holder.cardView.setVisibility(View.VISIBLE);
            //++i;
            holder.team1name.setText(match.matchInfo.team1.teamSName.toString());
            holder.team2name.setText(match.matchInfo.team2.teamSName.toString());
            //      holder.team2name.setText(list.get(0).matchDetailsMap.match.get(0).matchInfo.team2.teamSName);

            holder.matchBrief.setText(match.matchInfo.matchDesc + ". " + match.matchInfo.venueInfo.city);
            //  holder.team2name.setText(model.getTeam2Name());
            Picasso.get()
                    .load("https://countryflagsapi.com/png/" + match.matchInfo.team1.teamName.toLowerCase())
                    .placeholder(R.drawable.ic_baseline_flag_24)
                    .into(holder.team1flag);

            Picasso.get()
                    .load("https://countryflagsapi.com/png/" + match.matchInfo.team2.teamName.toLowerCase())
                    .placeholder(R.drawable.ic_baseline_flag_24)
                    .into(holder.team2flag);

            holder.dateAndTime.setText(getDate(match.matchInfo.startDate));
            // holder.team2flag.setImageResource(model.getImageTeam2());
            //  holder.team1flag. setImageResource(model.getImageTeam1());
            //    holder.matchStatus.setText((String) matchDetail.matchDetailsMap.match.get(0).matchInfo.status);
            if (match.matchScore != null && match.matchScore.team1Score != null) {
                holder.team1score.setText(match.matchScore.team1Score.inngs1.runs + "" + "-" + match.matchScore.team1Score.inngs1.wickets + "" + " (" + match.matchScore.team1Score.inngs1.overs + ")" + "");

                if (match.matchScore != null && match.matchScore.team2Score != null) {

                    holder.team2score.setText(match.matchScore.team2Score.inngs1.runs + "" + "-" + match.matchScore.team2Score.inngs1.wickets + "" + " (" + match.matchScore.team2Score.inngs1.overs + ")" + "");
                    if (match.matchScore.team1Score.inngs1.runs > match.matchScore.team2Score.inngs1.runs) {
                        holder.team1score.setTextColor(ContextCompat.getColor(context, R.color.black));

                    } else if (match.matchScore.team1Score.inngs1.runs < match.matchScore.team2Score.inngs1.runs) {
                        holder.team2score.setTextColor(ContextCompat.getColor(context, R.color.black));

                    } else {
                        holder.team1score.setTextColor(ContextCompat.getColor(context, R.color.black));
                        holder.team2score.setTextColor(ContextCompat.getColor(context, R.color.black));

                    }

                    //   holder.team2score.setText(match.matchScore.team2Score.inngs1.runs + "");
                    holder.matchStatus.setText(match.matchInfo.status);
                }
            }else {
                    holder.matchStatus.setText(getTime(match.matchInfo.startDate));
                }
                // holder.team2score.setText(match.matchScore.team2Score.inngs1.runs + "");
//        holder.dateAndTime.setText(matchDetail.matchDetailsMap.key);

            }
        }


    public static void hideView(View view) {
        view.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    // private String getTime(Long Timestamp) {
    private String getTime(long time) {


        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("hh:mm:ss", cal).toString();
        return date;
    }

    private String getDate(long time) {

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy ", cal).toString();
        return date;
    }


    class viewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout rootView;
        TextView team1name, team2name, team1score, team2score, seriesName, matchBrief,
                matchStatus, schedule, dateAndTime, status;
        ImageView team1flag, team2flag;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.root_view);
            cardView = itemView.findViewById(R.id.cardView_matchSchedule);
            team1name = itemView.findViewById(R.id.teamname1match);
            team2name = itemView.findViewById(R.id.teamname2match);
            team1score = itemView.findViewById(R.id.team1scorematch);
            team2score = itemView.findViewById(R.id.team2scorematch);
            matchStatus = itemView.findViewById(R.id.matchStatusmatch);
            //          seriesName=itemView.findViewById(R.id.seriesNamematch);
            team2flag = itemView.findViewById(R.id.imgteam2match);
            team1flag = itemView.findViewById(R.id.imgteam1match);
            matchBrief = itemView.findViewById(R.id.matchbriefmatch);
            //   schedule=itemView.findViewById(R.id.schedule);

            dateAndTime = itemView.findViewById(R.id.dateAndTime);
            //     status=itemView.findViewById(R.id.matchStatusmatch);
        }
    }
}
