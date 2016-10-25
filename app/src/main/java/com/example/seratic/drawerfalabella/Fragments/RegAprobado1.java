package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.seratic.drawerfalabella.R;


public class RegAprobado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    EditText telefono;
    private SharedPreferences prefs;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_telefono, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_1p_telfono);
        telefono = (EditText) view.findViewById(R.id.tvPhone_1p_telefono);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_telefono);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_telefono);
        aceptar.setOnClickListener(this);


        prefs = getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
        String tel = prefs.getString("telefono", "");
        telefono.setText(tel);
        int conc = prefs.getInt("concreto", 0);
        if (conc==1){
            si.setChecked(true);
        }else {
            no.setChecked(true);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_1p_telfono:
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    RegistroLlamadas registroLlamadas= new RegistroLlamadas();
                    fragmentTransaction.replace(R.id.fragment, registroLlamadas);
                    fragmentTransaction.commit();
        }
    }
}
