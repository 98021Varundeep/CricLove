package com.example.cricketapplicationn.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.example.cricketapplicationn.Adapter.InternationalAdapter;
import com.example.cricketapplicationn.Adapter.RecentAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.drawerActivity;


public class InternationalFragment extends Fragment {

    HorizontalScrollView scrollView;
    RecyclerView recyclerView;
    TypeMatch typeMatch;
//    RecentAdapter adapter;
    ProgressDialog dialog;
    RequestManager manager;

    public InternationalFragment() {
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


        View view = inflater.inflate(R.layout.fragment_international, container, false);
         drawerActivity activity= (drawerActivity) getActivity();
        Bundle data=activity.getMyDataInternational();
        if(data!=null){
            typeMatch= (TypeMatch) data.getSerializable("list");
            Toast.makeText(activity, "List not null", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(activity, "List is empty", Toast.LENGTH_SHORT).show();
        }
        scrollView = view.findViewById(R.id.scrollView_international);


         recyclerView= view.findViewById(R.id.recycler_international);
        //     recycler_recent.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
         recyclerView.setAdapter(new InternationalAdapter(getContext(),typeMatch));
        //  adapter=new RecentAdapter(getContext(),list);
        // recycler_recent.setAdapter(adapter);

        //list=new ArrayList<>();
        //    dialog=new ProgressDialog(getContext());
        // dialog.setTitle("Loading..");
        // dialog.show();
        //manager = new RequestManager(getContext());
       // manager.getFixture(listener, "live");

        //    list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        //   list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("Australia","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("Newzealnad","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("SouthAfrica","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("India","SouthAfrica","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.ic_baseline_flag_24));

        return view;
    }

}