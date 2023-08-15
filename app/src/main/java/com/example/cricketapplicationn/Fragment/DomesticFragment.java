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

import com.example.cricketapplicationn.Adapter.DomesticAdapter;
import com.example.cricketapplicationn.Adapter.InternationalAdapter;
import com.example.cricketapplicationn.Adapter.RecentAdapter;
import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.TypeMatch;
import com.example.cricketapplicationn.R;
import com.example.cricketapplicationn.drawerActivity;


public class DomesticFragment extends Fragment {
    TypeMatch typeMatch;
    HorizontalScrollView scrollView;
    RecyclerView recycler_domestic;

    RecentAdapter adapter;
    ProgressDialog dialog;
    RequestManager manager;

    public DomesticFragment() {
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

        drawerActivity activity= (drawerActivity) getActivity();
        Bundle data=activity.getMyDataDomestic();
        if(data!=null){
            typeMatch= (TypeMatch) data.getSerializable("list");
        }
        View view = inflater.inflate(R.layout.fragment_domestic, container, false);
        scrollView = view.findViewById(R.id.scrollView_domestic);

        recycler_domestic = view.findViewById(R.id.recycler_domestic);
        //     recycler_recent.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recycler_domestic.setHasFixedSize(true);
        recycler_domestic.setNestedScrollingEnabled(false);
         recycler_domestic.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recycler_domestic.setAdapter(new InternationalAdapter(getContext(),typeMatch));
        //  adapter=new RecentAdapter(getContext(),list);
        // recycler_recent.setAdapter(adapter);

        //list=new ArrayList<>();
        //    dialog=new ProgressDialog(getContext());
        // dialog.setTitle("Loading..");
        // dialog.show();
//        manager = new RequestManager(getContext());
  //      manager.getFixture(listener, "live");

        //    list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        //   list.add(new Matchbasicinfo("India","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("Australia","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("Newzealnad","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.flagindian,R.drawable.ic_baseline_flag_24));
        // list.add(new Matchbasicinfo("SouthAfrica","Pakistan","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.pakistan));
        // list.add(new Matchbasicinfo("India","SouthAfrica","170-9","179-10","India won by 9 runs","Asia Cup ",R.drawable.ic_baseline_flag_24,R.drawable.ic_baseline_flag_24));

        return view;
    }


}