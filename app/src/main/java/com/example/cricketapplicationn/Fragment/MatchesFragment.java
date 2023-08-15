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

import com.example.cricketapplicationn.Adapter.MatchesAdapter;
import com.example.cricketapplicationn.Adapter.RecentAdapter;
import com.example.cricketapplicationn.Adapter.Schhedulefragmentadapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.MatchDetail;
import com.example.cricketapplicationn.Model.Matchbasicinfo;
import com.example.cricketapplicationn.Model.SereisMatches;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ScheduleActivity;
import com.example.cricketapplicationn.SeriesResponseListener;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    int seriesID;
    ProgressDialog dialog;

    // List<Matchbasicinfo> list;
    RecentAdapter adapter;
    RequestManager manager;
    RecyclerView scheduleRV;

    public MatchesFragment() {
        // Required empty public constructor
    }

    public MatchesFragment(int seriesid) {
        seriesID = seriesid;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        ScheduleActivity activity = (ScheduleActivity) getActivity();
        Bundle data = activity.getMyData();
        if (data != null) {


            seriesID = data.getInt("SeriesId");
        }
        dialog = new ProgressDialog(getContext());
        dialog.setTitle("Loading...");
        scheduleRV = view.findViewById(R.id.scheduleRV);
        //    list=new ArrayList<>();
      //  scheduleRV.setHasFixedSize(true);
        scheduleRV.setLayoutManager(new LinearLayoutManager(getContext()));

        manager = new RequestManager(getContext());
        manager.getSeriesMatches(listener, seriesID);
        return view;
    }

    private final SeriesResponseListener<SereisMatches> listener = new SeriesResponseListener<SereisMatches>() {
        @Override
        public void didError(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void didFetch(List<MatchDetail> response, String message) {
            dialog.setTitle("Loading..");
            dialog.show();
            if (response == null) {
                Toast.makeText(getContext(), "Can not load data", Toast.LENGTH_SHORT).show();
            } else {
                MatchesAdapter adapter1 = new MatchesAdapter(getContext(), response);
                scheduleRV.setAdapter(adapter1);
                //   scheduleRV.setHasFixedSize(true);
                adapter1.notifyDataSetChanged();
            }
            dialog.hide();
        }
    };
}