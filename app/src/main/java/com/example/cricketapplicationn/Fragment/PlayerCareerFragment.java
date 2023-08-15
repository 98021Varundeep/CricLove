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

import com.example.cricketapplicationn.Adapter.CareerAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.Value;
import com.example.cricketapplicationn.PlayerActivity;
import com.example.cricketapplicationn.PlayerCareerListener;
import com.example.cricketapplicationn.R;

import java.util.List;

public class PlayerCareerFragment extends Fragment {
   int playerId;
    RecyclerView recyclerView;
   RequestManager manager;
   ProgressDialog dialog;

    public PlayerCareerFragment() {
        // Required empty public constructor
    }

    public PlayerCareerFragment(int playerId){
  this.playerId=playerId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_player_career, container, false);
       PlayerActivity activity= (PlayerActivity) getActivity();
       Bundle result= activity.getMyData();
       if(result!=null){
           playerId=result.getInt("playerId");
       }
       else{

       }
        dialog=new ProgressDialog(getContext());
        recyclerView=view.findViewById(R.id.recycler_career);
        dialog.setTitle("Loading Career...");
        dialog.show();
        manager=new RequestManager(getContext());
        manager.getPlayerCareer(listener,playerId);

       return view;
    }
 private final PlayerCareerListener listener=new PlayerCareerListener() {
     @Override
     public void didFetch(List<Value> values, String message) {
      dialog.hide();
         if(values==null){
          Toast.makeText(getContext(), "Can not Load data", Toast.LENGTH_SHORT).show();
      }
      else {
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
          recyclerView.setAdapter(new CareerAdapter(values, getContext()));

      }
     }

     @Override
     public void didError(String message) {
         dialog.hide();
         Toast.makeText(getContext(), "Error ,Try Later", Toast.LENGTH_SHORT).show();
     }
 };
}