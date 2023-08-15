package com.example.cricketapplicationn.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cricketapplicationn.Fragment.LiveFragment;
import com.example.cricketapplicationn.Fragment.RecentFragment;
import com.example.cricketapplicationn.Fragment.UpcomingFragment;
import com.example.cricketapplicationn.Fragment.YouselectFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new RecentFragment();
        else if(position==1)
            return new LiveFragment();
        else if(position==2)
            return new UpcomingFragment();
          else
              return new RecentFragment();

    }


    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

      String title="";
      if(position==0)
          return title="Recent";
      else if(position==1)
          return title="Live";
      else if(position==2)
          return title="Upcoming";

        return title;
    }
}
