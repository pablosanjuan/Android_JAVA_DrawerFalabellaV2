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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Aprobado3 extends Fragment implements View.OnClickListener {

    Button aceptar;
    private RadioButton si,no,otro;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_3rtas, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg_3rtas);
        aceptar.setOnClickListener(this);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_3r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_3r);
        otro = (RadioButton) view.findViewById(R.id.rb_otro_1p_3r);
        si.setText("No Interesado");
        no.setText("Ya Posee");
        otro.setText("Otro, cual?");
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_una_preg_3rtas:
                SharedPreferences preferencias=getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                if (si.isChecked()){

                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("motivo", 1);
                    editor.putString("descripcion", "");
                    editor.commit();

                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("motivo", 2);
                    editor.putString("descripcion", "");
                    editor.commit();

                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(otro.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("motivo", 3);
                    editor.commit();

                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Aprobado4 aprobado4 = new Aprobado4();
                    fragmentTransaction.replace(R.id.fragment, aprobado4);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
        }
    }
}
