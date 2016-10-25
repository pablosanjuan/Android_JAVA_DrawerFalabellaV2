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

import com.example.seratic.drawerfalabella.R;


public class Aprobado4 extends Fragment implements View.OnClickListener {

    Button aceptar;
    EditText edt_descripcion;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.solo_descripcion, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_solo_descripcion);
        edt_descripcion = (EditText) view.findViewById(R.id.edt_descripcion);
        aceptar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_solo_descripcion:

                SharedPreferences preferencias=getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("descripcion", edt_descripcion.getText().toString());
                editor.commit();

                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BandejaClientes bandejaClientes = new BandejaClientes();
                fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                fragmentTransaction.commit();
        }
    }
}
