package com.example.carme.parcial2csolano;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class GamesFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;


   // private OnFragmentInteractionListener mListener;

   // public GamesFragment() {
        // Required empty public constructor
  //  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_games, container, false);
         View frame = (View)container.getParent();
         appBar=(AppBarLayout)frame.findViewById(R.id.appBar);
         tabs= new TabLayout(getActivity());
         tabs.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
         appBar.addView(tabs);

         viewPager=(ViewPager)view.findViewById(R.id.viewPager);
         ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getFragmentManager());
         viewPager.setAdapter(pagerAdapter);
         tabs.setupWithViewPager(viewPager);


        return view;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        appBar.removeView(tabs);

    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String[] tituloTabs={"GENERAL", "TOP PLAYERS", "IMAGES"};

        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0: return new GeneralFragment();
                case 1: return new TopPlayersFragment();
                case 2: return new ImagesFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position];
        }
    }


}
