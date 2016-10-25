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
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class Aprobado1 extends Fragment implements View.OnClickListener{

    Button aceptar;
    ImageButton atras;
    RadioButton si,no;
    TextView numero_preg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.una_preg_2rtas, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2r);
        si.setOnClickListener(this);
        no.setOnClickListener(this);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        numero_preg.setText("1 de 2");
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
                BandejaClientes bandejaClientes= new BandejaClientes();
                fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_una_preg:
                SharedPreferences preferencias=getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                if (si.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("concreto", 1);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Aprobado2 aprobado2 = new Aprobado2();
                    fragmentTransaction.replace(R.id.fragment, aprobado2);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("concreto", 2);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    Aprobado3 aprobado3 = new Aprobado3();
                    fragmentTransaction.replace(R.id.fragment, aprobado3);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.rb_si_1p_2r:
                numero_preg.setText("1 de 2");
                aceptar.setText("Siguiente");
                break;
            case R.id.rb_no_1p_2r:
                numero_preg.setText("1 de 2");
                aceptar.setText("Siguiente");
                break;
        }
    }
}
