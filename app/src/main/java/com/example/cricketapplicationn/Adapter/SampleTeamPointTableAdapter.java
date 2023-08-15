package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.PointsTableInfo;
import com.example.cricketapplicationn.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class
SampleTeamPointTableAdapter extends RecyclerView.Adapter<SampleTeamPointTableAdapter.viewHolder>{
    Context context;
    List<PointsTableInfo> list;

    public SampleTeamPointTableAdapter(Context context, List<PointsTableInfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.samleteampointtable,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
   PointsTableInfo model =list.get(position);
    holder.played.setText(list.get(position).matchesPlayed+"");
    holder.win.setText(model.matchesWon+"");
        Picasso.get()
                .load("https://countryflagsapi.com/png/"+model.teamFullName.toLowerCase())
                        .placeholder(R.drawable.ic_baseline_flag_24)
                                .into(holder.countryFlag);
    holder.lost.setText(model.matchesLost+"");
    holder.nrr.setText(model.nrr+"");
    holder.nr.setText(0+"");
    holder.serialNo.setText(position+1+"");
    holder.points.setText(model.points+"");
    holder.countryName.setText(model.teamName);
 //   holder.serialNo.setText();
    holder.points.setText(model.points+"");



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
   {
    TextView played,win,lost,nrr,nr,points,countryName,serialNo;
  ImageView countryFlag ;
     public viewHolder(@NonNull View itemView) {
       super(itemView);
     played =itemView.findViewById(R.id.played);
     win =itemView.findViewById(R.id.win);
     lost =itemView.findViewById(R.id.lost);
     nrr =itemView.findViewById(R.id.nrr);
     nr =itemView.findViewById(R.id.nr);
     points=itemView.findViewById(R.id.points);
     countryName =itemView.findViewById(R.id.countryName);
     serialNo=itemView.findViewById(R.id.serielNo);
     countryFlag=itemView.findViewById(R.id.countryFlagpointTable);
     }
   }
}
