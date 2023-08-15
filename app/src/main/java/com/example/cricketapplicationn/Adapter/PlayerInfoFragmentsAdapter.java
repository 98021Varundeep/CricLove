package com.example.cricketapplicationn.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cricketapplicationn.Fragment.PlayerBioFragment;
import com.example.cricketapplicationn.Fragment.PlayerCareerFragment;

public class PlayerInfoFragmentsAdapter extends FragmentPagerAdapter {


    public PlayerInfoFragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
    switch (position){
        case 0:
            return new PlayerBioFragment();
        case 1:
            return new PlayerCareerFragment();
        default:
            return new PlayerBioFragment();
    }
   //     return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        if(position==0)
            return title="INFO";
        else {
            return title="CAREER";
        }
        //return super.getPageTitle(position);
    }
}
