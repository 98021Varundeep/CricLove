package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.SeriesVenue;
import com.example.cricketapplicationn.R;

import java.util.List;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.viewHolder>
{
  Context context;
  List<SeriesVenue> list;



    public VenuesAdapter(Context context, List<SeriesVenue> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.stadium_sample,parent,false);
   return  new viewHolder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
//    SeriesVenue venue=list.get(position)
     holder.stadiumName.setText(list.get(position).ground);
     holder.stadiumPlace.setText(list.get(position).city);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
  ImageView stadiumImage;
  TextView stadiumName,stadiumPlace;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
      stadiumImage=itemView.findViewById(R.id.stadiumImage);
      stadiumName=itemView.findViewById(R.id.stadiumName);
      stadiumPlace=itemView.findViewById(R.id.stadiumLocation);
        }
    }
}
