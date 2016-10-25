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


public class RegistroLlamadas extends Fragment implements View.OnClickListener {

    String[] estado = new String[]{
            "Prod: Ahorros",
            "Venta: NO, Motivo A",
            "Venta: NO",
            "Prod: Ahorros",
    };

    String[] descripcion = new String[]{
            "Jose Luis Ceron",
            "Marcela Martinez",
            "Pablo Sanjuan",
            "Marcela Martinez",
    };

    String[] hora = new String[]{
            "3 min",
            "5 hr",
            "4 oct",
            "23 sep",
    };

    String[] titulo = new String[]{
            "Aprobado",
            "No Encontrado",
            "Denegado",
            "No Encontrado",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
            R.drawable.ic_warning_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
    };

    ImageButton buscar_btn;
    ListViewAdapter2 adapter;
    TextView txt;
    EditText buscar_edt;
    private SharedPreferences prefs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bandeja_clientes, container, false);
        ((Index) getActivity()).getSupportActionBar().setTitle("Registro de Llamadas");

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter2(getContext(), titulo, descripcion, estado, hora, imagenes);
        lista.setAdapter(adapter);
        txt = (TextView) view.findViewById(R.id.text_bandeja);
        txt.setText("");
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
                        comprobar("nn");
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
                prefs = getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                int est_conc = prefs.getInt("concreto", 0);
                if (est_conc==1){
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    RegAprobado1 regaprobado1 = new RegAprobado1();
                    fragmentTransaction.replace(R.id.fragment, regaprobado1);
                    fragmentTransaction.commit();
                }else{
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    RegAprobado2 regaprobado2= new RegAprobado2();
                    fragmentTransaction.replace(R.id.fragment, regaprobado2);
                    fragmentTransaction.commit();
                }
                break;
            case "dd":
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Denegado1 denegado1 = new Denegado1();
                fragmentTransaction.replace(R.id.fragment, denegado1);
                fragmentTransaction.commit();
                break;
            default:
                prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                int ofrece = prefs.getInt("ofrece", 0);
                if (ofrece==1){
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    RegNoEncontrado1 regNoEncontrado1 = new RegNoEncontrado1();
                    fragmentTransaction.replace(R.id.fragment, regNoEncontrado1);
                    fragmentTransaction.commit();
                }else{
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    RegNoEncontrado2 regNoEncontrado2 = new RegNoEncontrado2();
                    fragmentTransaction.replace(R.id.fragment, regNoEncontrado2);
                    fragmentTransaction.commit();
                }
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
                        case "aa":
                            comprobar("aa");
                            break;
                        case "dd":
                            comprobar("dd");
                            break;
                        default:
                            comprobar("nn");
                            break;
                    }
                } else {
                    err();
                }
                break;
        }
    }

    public void err() {
        Toast toast1 = Toast.makeText(getContext(), "Ingrese dni, nombre ó Cédula para realizar una busqueda", Toast.LENGTH_SHORT);
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