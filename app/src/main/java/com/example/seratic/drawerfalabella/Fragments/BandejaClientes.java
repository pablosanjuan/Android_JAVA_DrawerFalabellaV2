package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter2;
import com.example.seratic.drawerfalabella.Index;
import com.example.seratic.drawerfalabella.R;


public class BandejaClientes extends Fragment implements View.OnClickListener {

    String[] estado = new String[]{
            "Prod: Ahorros",
            "Venta: NO, Motivo A",
            "Venta: NO",
            "Prod: Ahorros",
            "Prod: Crédito",
    };

    String[] descripcion = new String[]{
            "Jose Luis Ceron",
            "DNI: 3875345",
            "Pablo Sanjuan",
            "Jose Luis Ceron",
            "Pablo Sanjuan",
    };

    String[] hora = new String[]{
            "3 min",
            "15 min",
            "2 hr",
            "8 hr",
            "11 hr",
    };

    String[] titulo = new String[]{
            "Aprobado",
            "No Encontrado",
            "Denegado",
            "Aprobado",
            "Denegado",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
            R.drawable.ic_warning_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_warning_black_24dp,
    };

    ImageButton buscar_btn;
    ListViewAdapter2 adapter;
    TextView txt;
    EditText buscar_edt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bandeja_clientes, container, false);
        ((Index) getActivity()).getSupportActionBar().setTitle("Bandeja de Clientes");

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter2(getContext(), titulo, descripcion, estado, hora, imagenes);
        lista.setAdapter(adapter);
        txt = (TextView) view.findViewById(R.id.text_bandeja);
        txt.setText("Consultas del Dia: 5");
        buscar_btn = (ImageButton) view.findViewById(R.id.btnbuscar);
        buscar_btn.setOnClickListener(this);
        buscar_edt = (EditText) view.findViewById(R.id.edt_buscar);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        comprobar("aa");
                        break;
                    case 1:
                        comprobar("nn");
                        break;
                    case 2:
                        comprobar("dd");
                        break;
                    case 3:
                        comprobar("aa");
                        break;
                    case 4:
                        comprobar("dd");
                        break;
                }
            }
        });
        return view;
    }

    private void comprobar(String dato) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (dato) {
            case "aa":
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Aprobado1 aprobado1 = new Aprobado1();
                fragmentTransaction.replace(R.id.fragment, aprobado1);
                fragmentTransaction.commit();
                break;
            case "dd":
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Denegado1 denegado1 = new Denegado1();
                fragmentTransaction.replace(R.id.fragment, denegado1);
                fragmentTransaction.commit();
                break;
            case "nn":
                SharedPreferences preferencias1=getActivity().getSharedPreferences("dato", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor1=preferencias1.edit();
                editor1.putString("dni", "3875345");
                editor1.commit();

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                NoEncontrado1 noEncontrado2 = new NoEncontrado1();
                fragmentTransaction.replace(R.id.fragment, noEncontrado2);
                fragmentTransaction.commit();
                break;
            default:
                String dni_dato = buscar_edt.getText().toString();
                SharedPreferences preferencias=getActivity().getSharedPreferences("dato", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("dni", dni_dato);
                editor.commit();

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                NoEncontrado1 noEncontrado1 = new NoEncontrado1();
                fragmentTransaction.replace(R.id.fragment, noEncontrado1);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnbuscar:
                String txtbusc = buscar_edt.getText().toString();
                if (checklogindata(txtbusc) == true) {
                        switch (txtbusc){
                            case "111":
                                comprobar("aa");
                                break;
                            case "222":
                                comprobar("dd");
                                break;
                            default:
                                comprobar("df");
                                break;
                        }
                } else {
                    err();
                }
                break;
        }
    }

    public void err() {
        Toast toast1 = Toast.makeText(getContext(), "Ingrese DNI para realizar una busqueda", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public boolean checklogindata(String buscar) {
        if (buscar.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}