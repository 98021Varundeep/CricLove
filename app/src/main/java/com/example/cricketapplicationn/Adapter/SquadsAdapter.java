package com.example.cricketapplicationn.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.Squad;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.SquadActivity;

import java.util.List;

public class SquadsAdapter extends RecyclerView.Adapter<SquadsAdapter.viewHolder>{
    int SeriesId;
    Context context;
    List<Squad> list;

    public SquadsAdapter(Context context, List<Squad> list,int seriesid) {
        this.context = context;
        this.list = list;
     this.SeriesId=seriesid;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.sample_squad,parent,false);
         return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
//   Squad squad=list.get(position);
        if(list.get(position).isHeader==true){
          holder.squadName.setVisibility(View.GONE);
        }
  else {
      holder.squadName.setText(list.get(position).squadType);
        }

      holder.squadName.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(context, SquadActivity.class);
              intent.putExtra("TeamId",list.get(position).squadId);

                intent.putExtra("SeriesId",SeriesId);
        intent.putExtra("TeamName",list.get(position).squadType);
          context.startActivity(intent);

          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
         TextView squadName;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        squadName=itemView.findViewById(R.id.squadName);


        }

    }

}
