package com.example.cricketapplicationn.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cricketapplicationn.Fragment.MatchesFragment;
import com.example.cricketapplicationn.Fragment.PointTableFragment;
import com.example.cricketapplicationn.Fragment.SquadFragment;
import com.example.cricketapplicationn.Fragment.VenuseFragment;

public class Schhedulefragmentadapter extends FragmentPagerAdapter {
  int seriesID;
    public Schhedulefragmentadapter(@NonNull FragmentManager fm) {
        super(fm);

    }

     public Schhedulefragmentadapter(@NonNull FragmentManager fm,int id){
         super(fm);
          seriesID=id;
     }

    @NonNull
    @Override
    public Fragment getItem(int position) {
      switch (position){
     case 0:
              return new MatchesFragment(seriesID);
          case 1:
              return new SquadFragment(seriesID);
          case 2:
              return new VenuseFragment(seriesID);

          case 3:
              return new PointTableFragment(seriesID);

              default:
              return new MatchesFragment(seriesID);

      }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
      String title="";

        if(position==0)
            return title="Matches";
        else if(position==1)
            return title="Squad";
        else if(position==2)
       return title="Venues";
      else
          return title ="PointTable";
    }
}
