package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.Player;
import com.example.cricketapplicationn.PlayerActivity;
import com.example.cricketapplicationn.R;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter {
    Context context;
    List<Player> list;
    int PLAYER_DATA = 1;
    int PLAYER_HEADER = 2;

    public PlayersAdapter(Context context, List<Player> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==PLAYER_DATA){
            View view = LayoutInflater.from(context).inflate(R.layout.player_item,parent,false);
            return new playerHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.header_player,parent,false);
            return new headerHolder(view);

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isHeader == true)
            return PLAYER_HEADER;
        else
            return PLAYER_DATA;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
  if(holder.getClass()==playerHolder.class){
  //((playerHolder) holder).playerImage.
   if(list.get(position).captain==true){
       ((playerHolder) holder).playerName.setText(list.get(position).name+""+" (c)"+"");

   }
 else {
       ((playerHolder) holder).playerName.setText(list.get(position).name);
   }
 //  if(list.get())
  }
   else
  {
      ((headerHolder) holder).header.setText(list.get(position).name);

  }
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, PlayerActivity.class);
            intent.putExtra("id",list.get(position).id+"");

            Toast.makeText(context, list.get(position).id+"", Toast.LENGTH_SHORT).show();

            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();

    }


    class headerHolder extends RecyclerView.ViewHolder {
        TextView header;

        public headerHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header_player);
        }
    }

    class playerHolder extends RecyclerView.ViewHolder {
        TextView playerName;
        ImageView playerImage;

        public playerHolder(@NonNull View itemView) {
            super(itemView);
            playerImage = itemView.findViewById(R.id.profile_image_bio);
            playerName = itemView.findViewById(R.id.player_Name);
        }
    }

}
