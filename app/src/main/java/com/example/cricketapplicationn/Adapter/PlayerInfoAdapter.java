package com.example.cricketapplicationn.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.PlayerInfo;
import com.example.cricketapplicationn.R;

public class PlayerInfoAdapter extends RecyclerView.Adapter<PlayerInfoAdapter.viewHolder> {

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        public viewHolder(@NonNull View itemView) {
            super(itemView);

         }
    }
}
