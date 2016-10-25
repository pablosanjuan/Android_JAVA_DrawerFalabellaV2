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
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Denegado3 extends Fragment implements View.OnClickListener {

    Button aceptar;
    private RadioButton si,no,otro;
    TextView nombre,estado,doc;
    private ImageButton atras;
    TextView numero_preg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_3rtas, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg_3rtas);
        aceptar.setOnClickListener(this);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_3r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_3r);
        otro = (RadioButton) view.findViewById(R.id.rb_otro_1p_3r);
        si.setText("No Interesado");
        no.setText("Ya Posee");
        otro.setText("Otro, cual?");
        si.setOnClickListener(this);
        no.setOnClickListener(this);
        otro.setOnClickListener(this);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_3r);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_3r);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_3r);
        nombre.setText("Pablo Sanjuan");
        doc.setText("8234723");
        estado.setText("DENEGADO");
        estado.setTextColor(Color.parseColor("#FF5722"));
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
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
                Denegado1 denegado1= new Denegado1();
                fragmentTransaction.replace(R.id.fragment, denegado1);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_una_preg_3rtas:
                if (si.isChecked()){
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes = new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(otro.isChecked()){
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Denegado4 denegado4= new Denegado4();
                    fragmentTransaction.replace(R.id.fragment, denegado4);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.rb_si_1p_3r:
                numero_preg.setText("2 de 2");
                aceptar.setText("Finalizar");
                break;
            case R.id.rb_no_1p_3r:
                numero_preg.setText("2 de 2");
                aceptar.setText("Finalizar");
                break;
            case R.id.rb_otro_1p_3r:
                numero_preg.setText("2 de 3");
                aceptar.setText("Siguiente");
                break;
        }
    }
}
