package com.example.seratic.drawerfalabella.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.seratic.drawerfalabella.R;
import com.example.seratic.drawerfalabella.IndexBusq;

public class RegistroLlamadas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_starred, container, false);

        ((IndexBusq) getActivity()).getSupportActionBar().setTitle("");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentStarred);

        final TextView textViewStarredFragment = (TextView) view.findViewById(R.id.textViewStarredFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewStarredFragment.setTextSize(40);
                textViewStarredFragment.setText("This is the Starred Fragment");
                textViewStarredFragment.setTextColor(getResources().getColor(R.color.md_green_800));

            }
        });

        return view;
    }

}
