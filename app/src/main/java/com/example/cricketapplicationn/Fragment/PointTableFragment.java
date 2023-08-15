package com.example.cricketapplicationn.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.pointTableAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.PointsTable;
import com.example.cricketapplicationn.Model.getPointTable;
import com.example.cricketapplicationn.PointtableResposneLinstener;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;

import java.util.List;

public class PointTableFragment extends Fragment {
  int SeriesId;
     RequestManager manager;
     ProgressDialog dialog;
     RecyclerView recyclerView;
    public PointTableFragment() {
        // Required empty public constructor
    }

    public PointTableFragment(int seriesId){
        SeriesId=seriesId;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_point_table, container, false);
        ScheduleActivity activity= (ScheduleActivity) getActivity();
        Bundle data=activity.getMyData();
        if(data!=null){
            SeriesId=data.getInt("SeriesId");
            Toast.makeText(activity, SeriesId+"", Toast.LENGTH_SHORT).show();
        }
        recyclerView=view.findViewById(R.id.pointtablegroupRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        dialog=new ProgressDialog(getContext());
       manager=new RequestManager(getContext());
       dialog.setTitle("Loading...");
     dialog.show();
       manager.getPointTable(listener,SeriesId);


        return view;
    }

    PointtableResposneLinstener<getPointTable> listener=new PointtableResposneLinstener<getPointTable>() {
        @Override
        public void didFetch(List<PointsTable> response, String message) {
  dialog.hide();
  if(response==null){
      Toast.makeText(getContext(), "Response is Empty", Toast.LENGTH_LONG).show();
   }else {
      recyclerView.setAdapter(new pointTableAdapter(getContext(), response));
  }
        }

        @Override
        public void didError(String message) {
        dialog.hide();
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };
}