package com.example.seratic.drawerfalabella;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.Fragments.BandejaClientes;
import com.example.seratic.drawerfalabella.Fragments.RegistroLlamadas;
import com.example.seratic.drawerfalabella.Fragments.ResumenConsultas;

public class Index extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    private boolean canExitApp = false;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);
        setFragment(0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_search:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_resumen:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_registro:
                                menuItem.setChecked(true);
                                setFragment(2);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_setear:
                                new AlertDialog.Builder(Index.this)
                                        .setTitle("Resetear")
                                        .setMessage("Borrar todas las variables")
                                        .setCancelable(true)
                                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                setear();
                                            }
                                        }).create().show();

                        }
                        return true;
                    }
                });
    }

    private void setear() {
        SharedPreferences preferencias1=getSharedPreferences("aprobado", MODE_PRIVATE);
        SharedPreferences.Editor editor1=preferencias1.edit();
        editor1.putInt("concreto", 0);
        editor1.putString("telefono", "");
        editor1.putInt("motivo", 0);
        editor1.putInt("num_llamdas", 0);
        editor1.putString("descripcion", "");
        editor1.commit();

        SharedPreferences preferencias2=getSharedPreferences("no_encontrado", MODE_PRIVATE);
        SharedPreferences.Editor editor2=preferencias2.edit();
        editor2.putInt("ofrece", 0);
        editor2.putString("telefono", "");
        editor2.putInt("producto", 0);
        editor2.putInt("estado", 0);
        editor2.putString("dni", "");
        editor2.putString("descripcion", "");
        editor2.putString("nombre", "");
        editor2.commit();

        SharedPreferences preferencias3=getSharedPreferences("canto", MODE_PRIVATE);
        SharedPreferences.Editor editor3=preferencias3.edit();
        editor3.putInt("estado", 0);
        editor3.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        setFragment(0);

    }

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BandejaClientes bandejaClientes = new BandejaClientes();
                fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ResumenConsultas resumen_consultas = new ResumenConsultas();
                fragmentTransaction.replace(R.id.fragment, resumen_consultas);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                RegistroLlamadas registroLlamadas = new RegistroLlamadas();
                fragmentTransaction.replace(R.id.fragment, registroLlamadas);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            cerrar();
        }
    }

    private void cerrar() {
        if (!canExitApp) {
            canExitApp = true;
            Toast.makeText(this, "Presione dos veces para salir", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    canExitApp = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
        }
    }

}