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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Aprobado2 extends Fragment implements View.OnClickListener {

    Button aceptar;
    EditText telefono;
    TextView numero_preg;
    private ImageButton atras;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.solo_telefono, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        telefono = (EditText) view.findViewById(R.id.edt_s_telefono);
        aceptar = (Button) view.findViewById(R.id.aceptar_solo_telefono);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        aceptar.setText("Finalizar");
        numero_preg.setText("2 de 2");
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (view.getId()){
            case R.id.btn_atras:
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Aprobado1 aprobado1= new Aprobado1();
                fragmentTransaction.replace(R.id.fragment, aprobado1);
                fragmentTransaction.commit();
                break;

            case R.id.aceptar_solo_telefono:
                String tele = telefono.getText().toString();
                if (checklogindata(tele) == true) {
                    SharedPreferences preferencias = getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("telefono", tele);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }
                break;
        }
    }
        public boolean checklogindata(String buscar) {
            if (buscar.equals("")) {
                Toast toast1 = Toast.makeText(getContext(), "Ingrese el Telfono para continuar", Toast.LENGTH_SHORT);
                toast1.show();
                return false;
            } else {
                return true;
            }
        }
}
