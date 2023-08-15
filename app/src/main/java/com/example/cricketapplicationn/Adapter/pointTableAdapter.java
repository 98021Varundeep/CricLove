package com.example.cricketapplicationn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapplicationn.Model.PointsTable;
import com.example.cricketapplicationn.R;

import java.util.List;

public class pointTableAdapter extends RecyclerView.Adapter<pointTableAdapter.viewHolder>{

Context context;
List<PointsTable> list;


    public pointTableAdapter(Context context, List<PointsTable> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pointtablesample,parent,false);

      return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
  PointsTable model=list.get(position);
  holder.grouptitle.setText(model.groupName);
   holder.pointrowRV.setAdapter(new SampleTeamPointTableAdapter(context,model.pointsTableInfo));
   holder.pointrowRV.setLayoutManager(new LinearLayoutManager(context));
   holder.pointrowRV.setHasFixedSize(true);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  viewHolder extends RecyclerView.ViewHolder{
 TextView grouptitle;
 RecyclerView pointrowRV;
 TableLayout tableLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
    grouptitle=itemView.findViewById(R.id.grouptitle);
  pointrowRV =itemView.findViewById(R.id.pointRowsRV);
    tableLayout=itemView.findViewById(R.id.tableLayout);


        }
    }
}
