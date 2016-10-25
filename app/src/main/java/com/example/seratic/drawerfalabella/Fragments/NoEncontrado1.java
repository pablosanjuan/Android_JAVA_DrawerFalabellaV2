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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    TextView pregunta,estado, nombre, doc;
    private SharedPreferences prefs;
    EditText edt_nombre;
    private ImageButton atras;
    TextView numero_preg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.edt_una_preg_2rtas, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg);
        edt_nombre = (EditText) view.findViewById(R.id.edtNombre_1p_2r);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2r);
        si.setOnClickListener(this);
        no.setOnClickListener(this);
        pregunta = (TextView) view.findViewById(R.id.preg_una_preg_2r);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_2r);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_2r);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_2r);
        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        doc.setText(prefs.getString("dni", ""));
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        pregunta.setText("Se Ofrece producto?");
        aceptar.setOnClickListener(this);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
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
                String txt_nombre = edt_nombre.getText().toString();
                SharedPreferences preferencias=getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                if (si.isChecked()&&checklogindata(txt_nombre) == true){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("ofrece", 1);
                    editor.putString("nombre", txt_nombre);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NoEncontrado2 noEncontrado2 = new NoEncontrado2();
                    fragmentTransaction.replace(R.id.fragment, noEncontrado2);
                    fragmentTransaction.commit();
                }else if(no.isChecked()&&checklogindata(txt_nombre) == true){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("ofrece", 2);
                    editor.putString("nombre", txt_nombre);
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NoEncontrado3 noEncontrado3= new NoEncontrado3();
                    fragmentTransaction.replace(R.id.fragment, noEncontrado3);
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
    public boolean checklogindata(String buscar) {
        if (buscar.equals("")) {
            Toast toast1 = Toast.makeText(getContext(), "Ingrese el Nombre para porder continuar", Toast.LENGTH_SHORT);
            toast1.show();
            return false;
        } else {
            return true;
        }
    }
}
