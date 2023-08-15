package com.example.cricketapplicationn.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.example.cricketapplicationn.Adapter.InternationalAdapter;
import com.example.cricketapplicationn.Adapter.RecentAdapter;
import com.example.cricketapplicationn.Adapter.WomenAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;

public class WomenFragment extends Fragment {
    TypeMatch typeMatch;
    HorizontalScrollView scrollView;
    RecyclerView recycler_women;

    RecentAdapter adapter;
    ProgressDialog dialog;
    RequestManager manager;


    public WomenFragment() {
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

        View view = inflater.inflate(R.layout.fragment_women, container, false);
        scrollView = view.findViewById(R.id.scrollView_women);

        recycler_women = view.findViewById(R.id.recycler_women);
        //     recycler_recent.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recycler_women.setHasFixedSize(true);
        recycler_women.setNestedScrollingEnabled(false);
        recycler_women.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler_women.setAdapter(new InternationalAdapter(getContext(),typeMatch));
        //  adapter=new RecentAdapter(getContext(),list);
        // recycler_recent.setAdapter(adapter);

        //list=new ArrayList<>();
        //    dialog=new ProgressDialog(getContext());
        // dialog.setTitle("Loading..");
        // dialog.show();
     //   manager = new RequestManager(getContext());
      //  manager.getFixture(listener, "live");

        //    list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        //   list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("Australia","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("Newzealnad","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("SouthAfrica","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("India","SouthAfrica","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.ic_baseline_flag_24));

        return view;


    }
}