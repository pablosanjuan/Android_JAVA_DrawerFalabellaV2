package com.example.seratic.drawerfalabella.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Aprobado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_2rtas, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2r);
        aceptar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_una_preg:
                if (si.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Aprobado2 aprobado2 = new Aprobado2();
                    fragmentTransaction.replace(R.id.fragment, aprobado2);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Aprobado3 aprobado3 = new Aprobado3();
                    fragmentTransaction.replace(R.id.fragment, aprobado3);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
        }
    }
}
