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


public class ResConsultasAprob4 extends Fragment implements View.OnClickListener {

    Button aceptar;
    private RadioButton si,no,otro;
    TextView prgunta;
    private SharedPreferences prefs;
    private ImageButton atras;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_3rtas, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg_3rtas);
        aceptar.setOnClickListener(this);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_3r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_3r);
        otro = (RadioButton) view.findViewById(R.id.rb_otro_1p_3r);
        prgunta = (TextView) view.findViewById(R.id.preg_una_preg_3r);
        prgunta.setText("Canto de Venta");
        si.setText("Si");
        no.setText("No");
        otro.setText("Pendiente");
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);

        prefs = getActivity().getSharedPreferences("canto", getContext().MODE_PRIVATE);

        int est = prefs.getInt("estado", 0);
        if (est==1){
            si.setChecked(true);
        }else if (est==2){
            no.setChecked(true);
        }else if (est==3){
            otro.setChecked(true);
        }else {
            si.setChecked(false);
            no.setChecked(false);
            otro.setChecked(false);
        }
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
                ResConsultasAprob3 resConsultasAprob3= new ResConsultasAprob3();
                fragmentTransaction.replace(R.id.fragment, resConsultasAprob3);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_una_preg_3rtas:
                SharedPreferences preferencias=getActivity().getSharedPreferences("canto", getContext().MODE_PRIVATE);
                if (si.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 1);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    ResumenConsultas resumenConsultas = new ResumenConsultas();
                    fragmentTransaction.replace(R.id.fragment, resumenConsultas);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 2);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    ResumenConsultas resumenConsultas = new ResumenConsultas();
                    fragmentTransaction.replace(R.id.fragment, resumenConsultas);
                    fragmentTransaction.commit();
                }else if(otro.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("estado", 3);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    ResumenConsultas resumenConsultas = new ResumenConsultas();
                    fragmentTransaction.replace(R.id.fragment, resumenConsultas);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
