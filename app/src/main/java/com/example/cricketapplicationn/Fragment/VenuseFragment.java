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

import com.example.cricketapplicationn.Adapter.VenuesAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.getVenues;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;
import com.example.cricketapplicationn.VenueResponseListener;

public class VenuseFragment extends Fragment {

    int seriesID;
    RequestManager manager;
    ProgressDialog dialog;
    RecyclerView venuesRV;

    public VenuseFragment() {
        // Required empty public constructor

    }

    public VenuseFragment(int id) {
        seriesID = id;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_venuse, container, false);
        ScheduleActivity activity= (ScheduleActivity) getActivity();
        Bundle data=activity.getMyData();
        if(data!=null){
            seriesID=data.getInt("SeriesId");

        }
        venuesRV=view.findViewById(R.id.venuesRV);
        venuesRV.setLayoutManager(new LinearLayoutManager(getContext()));
        venuesRV.setHasFixedSize(true);

        dialog=new ProgressDialog(getContext());
      manager=new RequestManager(getContext());
      manager.getVenues(listener,seriesID);

        return view;
    }

 VenueResponseListener listener=new VenueResponseListener() {
     @Override
     public void didError(String message) {
         dialog.show();

         Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
       dialog.hide();
      }

     @Override
     public void didFetch(getVenues response, String message) {

          dialog.show();
         dialog.hide();
         VenuesAdapter adapter=new VenuesAdapter(getContext(),response.seriesVenue);
         venuesRV.setAdapter(adapter);



     }
 };
}