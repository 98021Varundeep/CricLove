package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.Value;
import com.example.cricketapplicationn.R;

import java.util.List;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.viewHodler>{

    public CareerAdapter(List<Value> list, Context context) {
        this.list = list;
        this.context = context;
    }

    List<Value> list;
    Context context;
    @NonNull
    @Override
    public viewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
 View view = LayoutInflater.from(context).inflate(R.layout.sample_career,parent,false);
    return new viewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHodler holder, int position) {

          holder.matchType.setText(list.get(position).name);
          holder.debut.setText(list.get(position).debut);
          holder.lastPlayed.setText(list.get(position).lastPlayed);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHodler extends RecyclerView.ViewHolder{
        TextView  matchType,debut,lastPlayed;



        public viewHodler(@NonNull View itemView) {
            super(itemView);
        matchType=itemView.findViewById(R.id.match_type);
        debut=itemView.findViewById(R.id.debut);
        lastPlayed=itemView.findViewById(R.id.lastPlayed);

        }
    }
}
