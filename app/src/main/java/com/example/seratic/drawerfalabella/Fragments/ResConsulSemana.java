package com.example.seratic.drawerfalabella.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter2;
import com.example.seratic.drawerfalabella.R;

import java.util.Calendar;


public class ResConsulSemana extends Fragment implements View.OnClickListener{

    String[] estado = new String[]{
            "Prod: Ahorros",
            "Prod: Ahorros",
            "Prod: Ahorros",
            "Prod: Ahorros",
            "Prod: Ahorros",
            "Prod: Ahorros",
    };

    String[] descripcion = new String[]{
            "Jose Luis Ceron",
            "Jose Luis Ceron",
            "Jose Luis Ceron",
            "Jose Luis Ceron",
            "Jose Luis Ceron",
            "Jose Luis Ceron",
    };

    String[] hora = new String[]{
            "8:45 am",
            "9:32 am",
            "11:34 am",
            "3:02 pm",
            "5:23 pm",
            "5:52 pm",
    };

    String[] titulo = new String[]{
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
    };

    ImageButton buscar_btn;
    ListViewAdapter2 adapter;
    TextView txt;
    EditText buscar_edt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_opc_filtro, container, false);

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int dayofyestreday = cal.get(Calendar.DAY_OF_MONTH)-1;


        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter2(getContext(), titulo, descripcion, estado, hora, imagenes);
        lista.setAdapter(adapter);
        txt = (TextView) view.findViewById(R.id.text_bandeja);
        txt.setText("Esta Semana");
        buscar_btn = (ImageButton) view.findViewById(R.id.btnopcinoes);
        buscar_btn.setOnClickListener(this);
        buscar_edt = (EditText) view.findViewById(R.id.edt_buscar);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                switch (i) {
                    case 0:
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        ResConsultasAprob3 resConsultasAprob3 = new ResConsultasAprob3();
                        fragmentTransaction.replace(R.id.fragment, resConsultasAprob3);
                        fragmentTransaction.commit();
                        break;
                    default:
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
            default:
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
            case R.id.btnopcinoes:
                Dialog d = new AlertDialog.Builder(getContext(),AlertDialog.THEME_HOLO_LIGHT)
                        .setTitle("Filtrar Por:")
                        .setNegativeButton("Cancelar", null)
                        .setItems(new String[]{"Hoy", "Ayer","Esta Semana"," Sel. Fecha"}, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dlg, int position)
                            {
                                FragmentManager fragmentManager;
                                FragmentTransaction fragmentTransaction;
                                if ( position == 0 ) {
                                    fragmentManager = getActivity().getSupportFragmentManager();
                                    fragmentTransaction = fragmentManager.beginTransaction();
                                    ResConsulHoy resConsulHoy= new ResConsulHoy();
                                    fragmentTransaction.replace(R.id.fragment, resConsulHoy);
                                    fragmentTransaction.commit();
                                } else if(position == 1){
                                    fragmentManager = getActivity().getSupportFragmentManager();
                                    fragmentTransaction = fragmentManager.beginTransaction();
                                    ResConsulAyer resConsulAyer= new ResConsulAyer();
                                    fragmentTransaction.replace(R.id.fragment, resConsulAyer);
                                    fragmentTransaction.commit();
                                } else if(position == 2){
                                    fragmentManager = getActivity().getSupportFragmentManager();
                                    fragmentTransaction = fragmentManager.beginTransaction();
                                    ResConsulSemana resConsulSemana= new ResConsulSemana();
                                    fragmentTransaction.replace(R.id.fragment, resConsulSemana);
                                    fragmentTransaction.commit();
                                } else if(position == 3){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    DatePicker picker = new DatePicker(getActivity());
                                    picker.setCalendarViewShown(false);

                                    builder.setTitle("Fecha Inicial");
                                    builder.setView(picker);
                                    builder.setNegativeButton("Cancelar", null);
                                    builder.setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            filtro();
                                        }
                                    });
                                    builder.show();
                                }
                            }
                        })
                        .create();
                d.show();
        }
    }
    public void filtro(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        DatePicker picker = new DatePicker(getActivity());
        picker.setCalendarViewShown(false);

        builder.setTitle("Fecha Final");
        builder.setView(picker);
        builder.setNegativeButton("Cancelar", null);
        builder.setPositiveButton("Filtrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ResConsulFecha resConsulFecha= new ResConsulFecha();
                fragmentTransaction.replace(R.id.fragment, resConsulFecha);
                fragmentTransaction.commit();;
            }
        });
        builder.show();

    }
}