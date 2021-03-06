package com.example.carme.parcial2csolano.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeccionesAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList= new ArrayList<>();
    private final List<String> titlesList = new ArrayList<>();


    public SeccionesAdapter(FragmentManager fm) {
        super(fm);
    }


    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        titlesList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
