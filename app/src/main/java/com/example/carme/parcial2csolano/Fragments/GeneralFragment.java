package com.example.carme.parcial2csolano.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carme.parcial2csolano.Adapters.GeneralAdapter;
import com.example.carme.parcial2csolano.Pojo.News;
import com.example.carme.parcial2csolano.R;

import java.util.ArrayList;


public class GeneralFragment extends Fragment {




    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerGenerals;
    ArrayList<News> generalList;

    public GeneralFragment() {
        // Required empty public constructor
    }


    public static GeneralFragment newInstance(String param1, String param2) {
        GeneralFragment fragment = new GeneralFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generalList= new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_general, container, false);
        recyclerGenerals= view.findViewById(R.id.recycler_generals);
        recyclerGenerals.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerGenerals.setHasFixedSize(true);

        GeneralAdapter adapter = new GeneralAdapter(generalList);
        recyclerGenerals.setAdapter(adapter);

        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
