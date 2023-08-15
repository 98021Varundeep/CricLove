package com.example.cricketapplicationn.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.RecentAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.FixtureResponse;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.ResponseListener;
import com.example.cricketapplicationn.drawerActivity;

import java.io.Serializable;
import java.util.List;


public class LiveFragment extends Fragment {

    HorizontalScrollView scrollView;
    RecyclerView recycler_live;
    List<TypeMatch> list;
    ProgressDialog dialog;
    RequestManager manager;



    public LiveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_live, container, false);
        recycler_live=view.findViewById(R.id.recycler_live);
        scrollView=view.findViewById(R.id.scrollView_live);
        recycler_live.setHasFixedSize(true);
        recycler_live.setNestedScrollingEnabled(false);
        recycler_live.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        manager = new RequestManager(getContext());
        manager.getFixture(listener, "live");


        return view;
    }

    private final ResponseListener<FixtureResponse> listener = new ResponseListener<FixtureResponse>() {

        @Override
        public void didFetch(List<TypeMatch> response, String message) {
            //         dialog.show();

            //dialog.dismiss();


            Toast.makeText(getContext(), "Hello ", Toast.LENGTH_SHORT).show();
            //    TypeMatch listt=  response.get(0);
            //   int  internationnal=listt.size();

            //   List<TypeMatch> listt2= (List<TypeMatch>) response.get(0);
            //  int  league=listt2.size();

            //List<TypeMatch> listt3= (List<TypeMatch>) response.get(0);
            //int  domestic=listt3.size();

            //List<TypeMatch> listt4= (List<TypeMatch>) response.get(0);
            // int  women=listt4.size();

            // RecentAdapter adapter1 = new RecentAdapter(getContext(), response);
            // recycler_recent.setAdapter(adapter1);

            // recycler_recent.
            Intent intent=new Intent(getContext(), drawerActivity.class);
            intent.putExtra("list", (Serializable) response);
            startActivity(intent);

        }


        @Override
        public void didError(String Message) {
            // dialog.show();
            // dialog.dismiss();
            Toast.makeText(getContext(), Message, Toast.LENGTH_SHORT).show();
        }

    };
}