package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
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

import com.example.seratic.drawerfalabella.R;


public class RegNoEncontrado2 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no,si1,no2,otro2;
    private SharedPreferences prefs;
    TextView desc;
    private TextView nombre;
    private TextView doc;
    private TextView estado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.dos_preg_descripcion, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_2p_d);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2p_d);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2p_d);
        si1 = (RadioButton) view.findViewById(R.id.rb_si_2p_2p_d);
        no2 = (RadioButton) view.findViewById(R.id.rb_no_2p_2p_d);
        otro2 = (RadioButton) view.findViewById(R.id.rb_otro_2p_2p_d);
        desc = (TextView) view.findViewById(R.id.txt_descrip);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_tlelfono_canto);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_telefono_cnato);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_telefono_canto);
        aceptar.setOnClickListener(this);
        nombre.setText("Marcela Martinez");
        doc.setText("16328136");
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));


        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        int conc = prefs.getInt("ofrece", 0);
        if (conc==1){
            si.setChecked(true);
        }else {
            no.setChecked(true);
        }

        int moti = prefs.getInt("estado", 0);
        if (moti==1){
            si1.setChecked(true);
        }else if (moti==2){
            no2.setChecked(true);
        }else if (moti==3){
            otro2.setChecked(true);
        }
        desc.setText("Descripción:" + prefs.getString("descripcion", ""));
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_2p_d:
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
