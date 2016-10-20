package com.example.seratic.drawerfalabella.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado2 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    TextView pregunta,estado,nombre,doc;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_telefono, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_1p_telfono);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_telefono);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_telefono);
        pregunta = (TextView) view.findViewById(R.id.preg_una_preg_telefono);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_tlelfono);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_telefono);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_telefono);
        nombre.setText("Marcela Martinez");
        doc.setText("16328136");
        estado.setText("No Encontrado");
        estado.setTextColor(Color.parseColor("#2196F3"));
        pregunta.setText("Producto?");
        si.setText("Ahorros");
        no.setText("Crédito");
        aceptar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_1p_telfono:
                if (si.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes= new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes= new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
        }
    }
}
