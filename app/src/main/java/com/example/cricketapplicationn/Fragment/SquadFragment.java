package com.example.cricketapplicationn.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.SquadsAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.GetSquads;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;
import com.example.cricketapplicationn.SquadResponseListener;

public class SquadFragment extends Fragment {
   int seriesID;

   RequestManager manager;
   ProgressDialog dialog;
   RecyclerView squadRV;
   TextView squadHeader;

    public SquadFragment() {
        // Required empty public constructor
    }
public SquadFragment(int seriesid)
{
        seriesID=seriesid;
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_squad, container, false);
       ScheduleActivity activity= (ScheduleActivity) getActivity();
       Bundle data=activity.getMyData();
       if(data!=null){
           seriesID=data.getInt("SeriesId");
       }
        dialog=new ProgressDialog(getContext());
        squadHeader=view.findViewById(R.id.squadHeader);
        squadRV=view.findViewById(R.id.squadRV);
           dialog.setTitle("Loading: Squads");
        manager=new RequestManager(getContext());

        manager.getSquads(listener,seriesID);
      return view;
    }
  SquadResponseListener listener=new SquadResponseListener() {
      @Override
      public void didError(String message) {
          dialog.show();
          Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
      dialog.dismiss();
      }

      @Override
      public void didFetch(GetSquads response, String message) {
        dialog.show();
        squadRV.setLayoutManager(new LinearLayoutManager(getContext()));
if(response==null){
    Toast.makeText(getContext(), "Can not load Data", Toast.LENGTH_SHORT).show();

}
else {
    squadRV.setAdapter(new SquadsAdapter(getContext(), response.squads,seriesID));
   squadHeader.setText(response.squads.get(0).squadType);
}
        dialog.dismiss();

      }
  };
}