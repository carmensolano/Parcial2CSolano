package com.example.carme.parcial2csolano.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carme.parcial2csolano.Adapters.SeccionesAdapter;
import com.example.carme.parcial2csolano.R;
import com.example.carme.parcial2csolano.Remote.Utilities;


public class ContenedorFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    View view;
    private AppBarLayout appBarLayout;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public ContenedorFragment() {
        // Required empty public constructor
    }


    public static ContenedorFragment newInstance(String param1, String param2) {
        ContenedorFragment fragment = new ContenedorFragment();
        Bundle args = new Bundle();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_contenedor, container, false);

        if(Utilities.rotacion==0){
            View parent= (View) container.getParent();

            if(appBarLayout==null){
                appBarLayout= (AppBarLayout) parent.findViewById(R.id.appBar);
                pestanas=new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
                appBarLayout.addView(pestanas);


                viewPager= (ViewPager) view.findViewById(R.id.contenedor);
                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            Utilities.rotacion=1;
        }


        return view;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter adapter=new SeccionesAdapter(getFragmentManager());
        adapter.addFragment(new GeneralFragment(),"Generals");
        adapter.addFragment(new TopPlayersFragment(),"Top Players");
        adapter.addFragment(new ImagesFragment(),"Images");
        viewPager.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Utilities.rotacion==0){
            appBarLayout.removeView(pestanas);
        }

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
